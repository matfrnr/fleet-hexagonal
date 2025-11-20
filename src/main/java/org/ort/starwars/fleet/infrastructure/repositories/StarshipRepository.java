package org.ort.starwars.fleet.infrastructure.repositories;

import org.ort.starwars.fleet.domain.models.entities.Starship;
import org.ort.starwars.fleet.domain.ports.out.StarshipRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StarshipRepository extends JpaRepository<Starship, Long>, StarshipRepositoryPort {
}