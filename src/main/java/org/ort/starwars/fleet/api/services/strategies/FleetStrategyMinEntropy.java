package org.ort.starwars.fleet.api.services.strategies;

import org.ort.starwars.fleet.api.models.Mission;
import org.ort.starwars.fleet.api.models.entities.Starship;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
@Order(1) // <--- IMPORTANT : On teste celle-ci en premier !
public class FleetStrategyMinEntropy implements FleetStrategy {

    @Override
    public boolean match(Mission mission) {
        return "TRANSPORT".equalsIgnoreCase(mission.getType()) && mission.isUrgent();
    }

    @Override
    public List<Starship> assign(List<Starship> availableShips, Mission mission) {
        List<Starship> sortedShips = new ArrayList<>(availableShips);
        sortedShips.sort(Comparator.comparingInt(Starship::getPassengers).reversed());

        List<Starship> fleet = new ArrayList<>();
        int passengersToBoard = mission.getPassengers();

        for (Starship ship : sortedShips) {
            if (passengersToBoard <= 0)
                break;
            if (ship.getPassengers() > 0) {
                fleet.add(ship);
                passengersToBoard -= ship.getPassengers();
            }
        }
        return fleet;
    }
}