package com.integradis.greenhouse.platform.crops.application.internal.commandservices;

import com.integradis.greenhouse.platform.crops.domain.exceptions.CropNotFoundException;
import com.integradis.greenhouse.platform.crops.domain.model.commands.CreateGrowRoomCommand;
import com.integradis.greenhouse.platform.crops.domain.model.entities.GrowRoomRecord;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetCropByIdQuery;
import com.integradis.greenhouse.platform.crops.domain.services.GrowRoomCommandService;
import com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories.CropRepository;
import com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories.GrowRoomRepository;
import org.springframework.stereotype.Service;

@Service
public class GrowRoomCommandServiceImpl implements GrowRoomCommandService {
    private final GrowRoomRepository growRoomRepository;
    private final CropRepository cropRepository;

    public GrowRoomCommandServiceImpl(GrowRoomRepository growRoomRepository, CropRepository cropRepository) {
        this.growRoomRepository = growRoomRepository;
        this.cropRepository = cropRepository;
    }

    @Override
    public Long handle(CreateGrowRoomCommand command) {
        var getCropByIdQuery = new GetCropByIdQuery(command.cropId());
        var crop = cropRepository.findById(getCropByIdQuery.id()).orElseThrow(
                () -> new CropNotFoundException(command.cropId()));
        var growRoom = new GrowRoomRecord(crop, command.author(), command.cropPhase(), command.grow_room(),
                command.air_temperature(), command.compost_temperature(), command.carbon_dioxide(),
                command.air_humidity(), command.setting(), command.comment());
        growRoomRepository.save(growRoom);
        return growRoom.getId();
    }
}
