package org.ort.starwars.fleet.api.services;

import org.ort.starwars.fleet.api.models.Mission;
import org.ort.starwars.fleet.api.models.entities.Starship;
import org.ort.starwars.fleet.api.models.repositories.StarshipRepository;
import org.ort.starwars.fleet.api.services.strategies.FleetStrategy;
import org.ort.starwars.fleet.utils.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FleetService {

    @Autowired
    private StarshipRepository starshipRepository;

    @Autowired
    private List<FleetStrategy> strategies;

    public List<Starship> forMission(Mission mission) {
        // 1. Récupérer toute la flotte disponible
        List<Starship> allShips = Iterables.toList(starshipRepository.findAll());

        // 2. Trouver la bonne stratégie
        for (FleetStrategy strategy : strategies) {
            if (strategy.match(mission)) {
                // 3. Appliquer la stratégie
                return strategy.assign(allShips, mission);
            }
        }
        return Collections.emptyList();
    }
}