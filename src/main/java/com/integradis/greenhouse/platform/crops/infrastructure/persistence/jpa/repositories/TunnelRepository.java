package com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories;

import com.integradis.greenhouse.platform.crops.domain.model.entities.Tunnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TunnelRepository extends JpaRepository<Tunnel, Long> {
    List<Tunnel> findAllByCropId(Long cropId);
}
