package com.integradis.greenhouse.platform.crops.domain.services;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.crops.domain.model.entities.Formula;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetCropByIdQuery;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetFormulaByIdQuery;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetFormulaEntriesByCropId;

import java.util.List;
import java.util.Optional;

public interface FormulaQueryService {
    List<Formula> handle (GetFormulaEntriesByCropId query);

    Optional<Formula> handle (GetFormulaByIdQuery query);
}
