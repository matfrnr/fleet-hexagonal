package org.ort.starwars.fleet.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.ort.starwars.fleet.configuration.Settings;

@RestController
public class HelloController {

    @Autowired
    private Settings settings;

    @GetMapping("/")
    public String get() {
        return settings.getVersion();
    }
}
