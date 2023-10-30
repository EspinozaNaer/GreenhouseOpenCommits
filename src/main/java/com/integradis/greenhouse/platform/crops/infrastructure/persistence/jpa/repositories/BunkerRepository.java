package com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories;

import com.integradis.greenhouse.platform.crops.domain.model.entities.Bunker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BunkerRepository extends JpaRepository<Bunker, Long> {
    List<Bunker> findAllByCropId(Long cropId);
}
