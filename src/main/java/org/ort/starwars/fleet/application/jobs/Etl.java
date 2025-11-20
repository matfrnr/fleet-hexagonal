package org.ort.starwars.fleet.application.jobs;

import org.ort.starwars.fleet.domain.models.entities.Starship;
import org.ort.starwars.fleet.infrastructure.dtos.SwapiPageDto;
import org.ort.starwars.fleet.infrastructure.mappers.SwapiStarshipMapper;
import org.ort.starwars.fleet.infrastructure.repositories.StarshipRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class Etl {

    private static final Logger LOGGER = LoggerFactory.getLogger(Etl.class);
    private static final String SWAPI_URL = "https://swapi.dev/api/starships";

    @Autowired
    private StarshipRepository repository;

    @Autowired
    private SwapiStarshipMapper mapper;

    private final WebClient webClient;

    public Etl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(SWAPI_URL).build();
    }

    @Scheduled(fixedRate = 3600000)
    @Transactional
    public void run() {
        LOGGER.info("Début de l'import des vaisseaux depuis SWAPI...");

        try {
            List<Starship> allShips = new ArrayList<>();
            String nextUrl = "/?page=1";

            while (nextUrl != null && !nextUrl.isEmpty()) {
                SwapiPageDto page = webClient.get()
                        .uri(nextUrl)
                        .retrieve()
                        .bodyToMono(SwapiPageDto.class)
                        .block();

                if (page == null)
                    break;

                List<Starship> pageShips = page.getResults().stream()
                        .map(mapper::toDomain)
                        .toList();

                allShips.addAll(pageShips);
                nextUrl = extractRelativeUrl(page.getNext());
            }

            if (!allShips.isEmpty()) {
                List<Starship> distinctShips = allShips.stream()
                        .filter(distinctByKey(Starship::getName))
                        .toList();

                // On vide la table immédiatement
                repository.deleteAllInBatch();

                // On insère les nouveaux
                repository.saveAll(new ArrayList<>(distinctShips));

                LOGGER.info("Import terminé ! {} vaisseaux importés.", distinctShips.size());
            }

        } catch (Exception e) {
            LOGGER.error("Erreur lors de l'import SWAPI", e);
        }
    }

    private String extractRelativeUrl(String fullUrl) {
        if (fullUrl == null)
            return null;
        if (fullUrl.contains("/api/starships")) {
            return fullUrl.substring(fullUrl.indexOf("/api/starships") + "/api/starships".length());
        }
        return null;
    }

    // Utilitaire pour filtrer les doublons sur le nom
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}