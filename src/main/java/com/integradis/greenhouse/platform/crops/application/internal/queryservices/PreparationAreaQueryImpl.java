package com.integradis.greenhouse.platform.crops.application.internal.queryservices;

import com.integradis.greenhouse.platform.crops.domain.model.entities.PreparationArea;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetPreparationAreaByIdQuery;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetPreparationAreaEntriesByCropIdQuery;
import com.integradis.greenhouse.platform.crops.domain.services.PreparationAreaQueryService;
import com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories.PreparationAreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreparationAreaQueryImpl implements PreparationAreaQueryService {
    private final PreparationAreaRepository preparationAreaRepository;

    public PreparationAreaQueryImpl(PreparationAreaRepository preparationAreaRepository) {
        this.preparationAreaRepository = preparationAreaRepository;
    }

    @Override
    public List<PreparationArea> handle(GetPreparationAreaEntriesByCropIdQuery query) {
        return preparationAreaRepository.findAllByCropId(query.cropId());
    }

    @Override
    public Optional<PreparationArea> handle(GetPreparationAreaByIdQuery query) {
        return preparationAreaRepository.findById(query.id());
    }


}
