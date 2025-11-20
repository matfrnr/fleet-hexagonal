package org.ort.starwars.fleet.infrastructure.controllers;

import org.ort.starwars.fleet.domain.models.Mission;
import org.ort.starwars.fleet.domain.models.entities.Starship;
import org.ort.starwars.fleet.domain.ports.in.AssignFleetPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiEndpointFleetController {

    @Autowired
    private AssignFleetPort useCase;

    @PostMapping("/fleet")
    public List<Starship> post(@RequestBody Mission mission) {
        return useCase.forMission(mission);
    }
}