package com.integradis.greenhouse.platform.crops.interfaces.rest.transform;

import com.integradis.greenhouse.platform.crops.domain.model.commands.CreateGrowRoomCommand;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.CreateGrowRoomResource;

public class CreateGrowRoomCommandFromResourceAssembler {
    public static CreateGrowRoomCommand toCommandFromResource(CreateGrowRoomResource resource){
        return new CreateGrowRoomCommand(resource.cropId(), resource.author(), resource.cropPhase(),
                resource.grow_room(), resource.air_temperature(), resource.compost_temperature(),
                resource.carbon_dioxide(), resource.air_humidity(), resource.setting(), resource.comment());
    }
}
