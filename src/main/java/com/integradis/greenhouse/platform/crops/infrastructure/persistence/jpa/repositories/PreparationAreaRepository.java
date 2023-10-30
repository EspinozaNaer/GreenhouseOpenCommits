package com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories;

import com.integradis.greenhouse.platform.crops.domain.model.entities.PreparationArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreparationAreaRepository extends JpaRepository<PreparationArea, Long> {
    List<PreparationArea> findAllByCropId(Long cropId);
}
