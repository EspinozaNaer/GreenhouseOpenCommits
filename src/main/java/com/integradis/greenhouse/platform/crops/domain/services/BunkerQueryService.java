package com.integradis.greenhouse.platform.crops.domain.services;

import com.integradis.greenhouse.platform.crops.domain.model.entities.Bunker;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetBunkerEntriesByCropIdQuery;

import java.util.List;

public interface BunkerQueryService {
    List<Bunker> handle (GetBunkerEntriesByCropIdQuery query);
}
