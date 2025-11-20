package org.ort.starwars.fleet.domain.services;

import org.ort.starwars.fleet.domain.models.Mission;
import org.ort.starwars.fleet.domain.models.entities.Starship;
import org.ort.starwars.fleet.domain.ports.in.AssignFleetPort;
import org.ort.starwars.fleet.domain.ports.out.StarshipRepositoryPort;
import org.ort.starwars.fleet.infrastructure.utils.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignFleetUseCase implements AssignFleetPort {

    @Autowired
    private StarshipRepositoryPort repository;

    @Autowired
    private FleetService service;

    @Override
    public List<Starship> forMission(Mission mission) {
        // Récupération des données
        List<Starship> allShips = Iterables.toList(repository.findAll());

        // Délégation au métier pur
        return service.forMission(allShips, mission);
    }
}