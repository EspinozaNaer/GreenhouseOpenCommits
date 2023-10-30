package com.integradis.greenhouse.platform.crops.domain.services;

import com.integradis.greenhouse.platform.crops.domain.model.entities.PreparationArea;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetPreparationAreaEntriesByCropIdQuery;

import java.util.List;

public interface PreparationAreaQueryService {
    List<PreparationArea> handle (GetPreparationAreaEntriesByCropIdQuery query);
}
