package com.integradis.greenhouse.platform.crops.interfaces.rest.transform;

import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.PreparationAreaResource;

public class PreparationAreaResourceFromEntityAssembler {
    public static PreparationAreaResource toResourceFromEntity(com.integradis.greenhouse.platform.crops.domain.model.entities.PreparationArea entity){
        return new PreparationAreaResource(entity.getId(), entity.getAuthor(), entity.getActivities(), entity.getTemperature(), entity.getComment());
    }
}
