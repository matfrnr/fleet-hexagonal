package org.ort.starwars.fleet.domain.services.strategies;

import org.ort.starwars.fleet.domain.models.Mission;
import org.ort.starwars.fleet.domain.models.entities.Starship;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class FleetStrategyDefaut implements FleetStrategy {
    @Override
    public boolean match(Mission mission) {
        return true;
    }

    @Override
    public List<Starship> assign(List<Starship> availableShips, Mission mission) {
        return Collections.emptyList();
    }
}