package org.ort.starwars.fleet.domain.models;

import lombok.Data;

@Data
public class Mission {
    private String type;
    private boolean urgent;
    private int passengers;
    private int distance;
}