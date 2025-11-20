package org.ort.starwars.fleet.domain.services;

import org.ort.starwars.fleet.domain.models.Mission;
import org.ort.starwars.fleet.domain.models.entities.Starship;
import org.ort.starwars.fleet.domain.services.strategies.FleetStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FleetService {

    @Autowired
    private List<FleetStrategy> strategies;

    // On lui passe la liste des vaisseaux (allShips) en paramètre
    public List<Starship> forMission(List<Starship> allShips, Mission mission) {
        for (FleetStrategy strategy : strategies) {
            if (strategy.match(mission)) {
                return strategy.assign(allShips, mission);
            }
        }
        return Collections.emptyList();
    }
}