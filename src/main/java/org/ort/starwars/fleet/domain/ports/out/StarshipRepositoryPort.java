package org.ort.starwars.fleet.domain.ports.out;

import org.ort.starwars.fleet.domain.models.entities.Starship;
import java.util.List;

public interface StarshipRepositoryPort {
    List<Starship> findAll();
    
    void deleteAllInBatch();

    <S extends Starship> List<S> saveAll(Iterable<S> entities);
}