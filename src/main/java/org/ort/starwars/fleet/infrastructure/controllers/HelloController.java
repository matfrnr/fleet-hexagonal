package org.ort.starwars.fleet.infrastructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ort.starwars.fleet.application.configuration.Settings;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HelloController {

    @Autowired
    private Settings settings;

    @GetMapping("/")
    public String get() {
        return settings.getVersion();
    }
}
