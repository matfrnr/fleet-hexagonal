package org.ort.starwars.fleet.domain.ports.in;

import org.ort.starwars.fleet.domain.models.Mission;
import org.ort.starwars.fleet.domain.models.entities.Starship;
import java.util.List;

public interface AssignFleetPort {
    List<Starship> forMission(Mission mission);
}