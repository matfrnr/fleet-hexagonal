package org.ort.starwars.fleet.infrastructure.dtos;

import lombok.Data;
import java.util.List;

@Data
public class SwapiPageDto {
    private int count;
    private String next;
    private String previous;
    private List<SwapiStarshipDto> results;
}