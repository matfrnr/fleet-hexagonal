package org.ort.starwars.fleet.api.models.entities;

import org.ort.starwars.fleet.api.models.enums.StarshipType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Starship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private StarshipType category;

    @Column
    private int length;

    @Column
    private int crew;

    @Column
    private int passengers;

    @Column
    private int count;
}