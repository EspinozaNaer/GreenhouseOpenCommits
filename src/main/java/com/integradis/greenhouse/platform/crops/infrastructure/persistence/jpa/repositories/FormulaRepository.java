package com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories;

import com.integradis.greenhouse.platform.crops.domain.model.entities.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormulaRepository extends JpaRepository<Formula, Long> {
    List<Formula> findAllByCropId(Long cropId);
}
