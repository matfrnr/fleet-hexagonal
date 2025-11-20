package org.ort.starwars.fleet.api.mappers;

import org.ort.starwars.fleet.api.dtos.SwapiStarshipDto;
import org.ort.starwars.fleet.api.models.entities.Starship;
import org.ort.starwars.fleet.api.models.enums.StarshipType;
import org.ort.starwars.fleet.utils.Parsing;
import org.springframework.stereotype.Component;

@Component
public class SwapiStarshipMapper {

    public Starship toDomain(SwapiStarshipDto dto) {
        return Starship.builder()
                .name(dto.getName())
                .count((int) (Math.random() * 50) + 1)
                .crew(parseFirstInt(dto.getCrew()))
                .passengers(parseFirstInt(dto.getPassengers()))
                .length(Parsing.getInt(dto.getLength(), 0))
                .category(guessCategory(dto.getStarship_class()))
                .build();
    }

    private int parseFirstInt(String value) {
        int[] range = Parsing.getRange(value);
        return range.length > 0 ? range[0] : 0;
    }

    // Logique pour deviner le type (Enum) à partir du texte de l'API
    private StarshipType guessCategory(String starshipClass) {
        if (starshipClass == null)
            return StarshipType.OTHER;

        String type = starshipClass.toLowerCase();

        if (type.contains("destroyer"))
            return StarshipType.DESTROYER;
        if (type.contains("fighter") || type.contains("interceptor"))
            return StarshipType.FIGHTER;
        if (type.contains("dreadnought"))
            return StarshipType.DREADNOUGHT;
        if (type.contains("station"))
            return StarshipType.STATION;
        if (type.contains("transport") || type.contains("freighter"))
            return StarshipType.CARGO;
        if (type.contains("shuttle") || type.contains("landing"))
            return StarshipType.CRAFT;

        return StarshipType.OTHER;
    }
}