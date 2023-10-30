package com.integradis.greenhouse.platform.crops.application.internal.queryservices;

import com.integradis.greenhouse.platform.crops.domain.model.entities.Tunnel;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetTunnelEntriesByCropIdQuery;
import com.integradis.greenhouse.platform.crops.domain.services.TunnelQueryService;
import com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories.TunnelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TunnelQueryImpl implements TunnelQueryService {
    private final TunnelRepository tunnelRepository;

    public TunnelQueryImpl(TunnelRepository tunnelRepository) {
        this.tunnelRepository = tunnelRepository;
    }

    @Override
    public List<Tunnel> handle(GetTunnelEntriesByCropIdQuery query) {
        return tunnelRepository.findAllByCropId(query.cropId());
    }
}
