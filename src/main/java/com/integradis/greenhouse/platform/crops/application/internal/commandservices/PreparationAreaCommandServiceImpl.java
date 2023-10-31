package com.integradis.greenhouse.platform.crops.application.internal.commandservices;

import com.integradis.greenhouse.platform.crops.domain.exceptions.CropNotFoundException;
import com.integradis.greenhouse.platform.crops.domain.model.commands.CreatePreparationAreaCommand;
import com.integradis.greenhouse.platform.crops.domain.model.entities.PreparationArea;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetCropByIdQuery;
import com.integradis.greenhouse.platform.crops.domain.services.PreparationAreaCommandService;
import com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories.CropRepository;
import com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories.PreparationAreaRepository;
import org.springframework.stereotype.Service;

@Service
public class PreparationAreaCommandServiceImpl implements PreparationAreaCommandService {
    private final PreparationAreaRepository preparationAreaRepository;
    private final CropRepository cropRepository;

    public PreparationAreaCommandServiceImpl(PreparationAreaRepository preparationAreaRepository, CropRepository cropRepository) {
        this.preparationAreaRepository = preparationAreaRepository;
        this.cropRepository = cropRepository;
    }


    @Override
    public Long handle(CreatePreparationAreaCommand command) {
        var getCropByIdQuery = new GetCropByIdQuery(command.cropId());
        var crop = cropRepository.findById(getCropByIdQuery.id()).orElseThrow(() -> new CropNotFoundException(command.cropId()));
        var preparationArea = new PreparationArea(crop, command.author(), command.activities(), command.temperature(), command.comment());
        preparationAreaRepository.save(preparationArea);
        return preparationArea.getId();
    }
}
