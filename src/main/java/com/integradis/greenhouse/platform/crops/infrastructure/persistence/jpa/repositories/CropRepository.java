package com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
    Optional<Crop> findById(Long id);
    List<Crop> findAllByCompanyId(Long companyId);
}
