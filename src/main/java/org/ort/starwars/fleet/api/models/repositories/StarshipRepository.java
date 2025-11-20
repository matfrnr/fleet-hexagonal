package org.ort.starwars.fleet.api.models.repositories;

import org.ort.starwars.fleet.api.models.entities.Starship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarshipRepository extends JpaRepository<Starship, Long> {
}