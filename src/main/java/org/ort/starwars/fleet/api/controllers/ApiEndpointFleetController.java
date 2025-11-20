package org.ort.starwars.fleet.api.controllers;

import org.ort.starwars.fleet.api.models.Mission;
import org.ort.starwars.fleet.api.models.entities.Starship;
import org.ort.starwars.fleet.api.services.FleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiEndpointFleetController {

    @Autowired
    private FleetService fleetService;

    @PostMapping("/fleet")
    public List<Starship> post(@RequestBody Mission mission) {
        return fleetService.forMission(mission);
    }
}