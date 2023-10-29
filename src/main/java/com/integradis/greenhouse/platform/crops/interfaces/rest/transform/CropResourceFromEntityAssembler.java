package com.integradis.greenhouse.platform.crops.interfaces.rest.transform;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.CropResource;

public class CropResourceFromEntityAssembler {
    public static CropResource toResourceFromEntity(Crop entity){
        return new CropResource(entity.getId(), entity.getCropPhase().name(),
                entity.getStartDate(), entity.getEndDate(), entity.isState(), entity.getCompany().getId());
    }
}
