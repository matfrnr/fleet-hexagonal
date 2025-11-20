package org.ort.starwars.fleet.api.services.strategies;

import org.ort.starwars.fleet.api.models.Mission;
import org.ort.starwars.fleet.api.models.entities.Starship;

import java.util.List;

public interface FleetStrategy {
    boolean match(Mission mission);

    List<Starship> assign(List<Starship> availableShips, Mission mission);
}