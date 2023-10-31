package com.integradis.greenhouse.platform.crops.application.internal.commandservices;

import com.integradis.greenhouse.platform.crops.domain.exceptions.CropNotFoundException;
import com.integradis.greenhouse.platform.crops.domain.model.commands.CreateBunkerCommand;
import com.integradis.greenhouse.platform.crops.domain.model.entities.Bunker;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetCropByIdQuery;
import com.integradis.greenhouse.platform.crops.domain.services.BunkerCommandService;
import com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories.BunkerRepository;
import com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories.CropRepository;
import org.springframework.stereotype.Service;

@Service
public class BunkerCommandServiceImpl implements BunkerCommandService {

    private final BunkerRepository bunkerRepository;
    private final CropRepository cropRepository;

    public BunkerCommandServiceImpl(BunkerRepository bunkerRepository, CropRepository cropRepository) {
        this.bunkerRepository = bunkerRepository;
        this.cropRepository = cropRepository;
    }

    @Override
    public Long handle(CreateBunkerCommand command) {
        var getCropByIdQuery = new GetCropByIdQuery(command.cropId());
        var crop = cropRepository.findById(getCropByIdQuery.id()).orElseThrow(() -> new CropNotFoundException(command.cropId()));
        var bunker = new Bunker(crop, command.author(), command.thermocoupleOne(), command.thermocoupleTwo(), command.thermocoupleThree(), command.averageThermocouple(), command.motorFrequency(), command.comment());
        bunkerRepository.save(bunker);
        return bunker.getId();
    }
}
