package com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories;

import com.integradis.greenhouse.platform.crops.domain.model.entities.GrowRoomRecord;
import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrowRoomRepository extends JpaRepository<GrowRoomRecord, Long> {
    List<GrowRoomRecord> findAllByCropIdAndCropPhase(Long cropId, CropPhase cropPhase);
}
