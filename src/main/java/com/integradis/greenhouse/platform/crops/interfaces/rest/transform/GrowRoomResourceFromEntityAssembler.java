package com.integradis.greenhouse.platform.crops.interfaces.rest.transform;

import com.integradis.greenhouse.platform.crops.domain.model.entities.GrowRoomRecord;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.GrowRoomResource;

public class GrowRoomResourceFromEntityAssembler {
    public static GrowRoomResource toResourceFromEntity(GrowRoomRecord entity){
        return new GrowRoomResource(entity.getId(), entity.getAuthor(), entity.getFormattedCropPhase(),
                entity.getGrow_room(), entity.getAir_temperature(), entity.getCompost_temperature(),
                entity.getCarbon_dioxide(), entity.getAir_humidity(), entity.getSetting(), entity.getComment());

    }
}
