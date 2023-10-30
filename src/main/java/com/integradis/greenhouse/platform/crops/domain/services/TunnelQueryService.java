package com.integradis.greenhouse.platform.crops.domain.services;

import com.integradis.greenhouse.platform.crops.domain.model.entities.Tunnel;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetTunnelEntriesByCropIdQuery;

import java.util.List;

public interface TunnelQueryService {
    List<Tunnel> handle (GetTunnelEntriesByCropIdQuery query);
}
