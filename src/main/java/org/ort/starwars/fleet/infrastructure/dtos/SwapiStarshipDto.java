package org.ort.starwars.fleet.infrastructure.dtos;

import lombok.Data;

@Data
public class SwapiStarshipDto {
    private String name;
    private String model;
    private String starship_class; 
    private String length;
    private String crew;
    private String passengers;
    private String url;
}