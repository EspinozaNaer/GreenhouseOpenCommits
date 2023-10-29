package com.integradis.greenhouse.platform.crops.domain.services;

import com.integradis.greenhouse.platform.crops.domain.model.entities.Formula;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetFormulaEntriesByCropId;

import java.util.List;

public interface FormulaQueryService {
    List<Formula> handle (GetFormulaEntriesByCropId query);
}
