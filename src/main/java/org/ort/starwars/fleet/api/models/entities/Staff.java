package org.ort.starwars.fleet.api.models.entities;

import org.ort.starwars.fleet.api.models.enums.Breed;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private final Breed breed;

    @Column
    private int recruits;
}