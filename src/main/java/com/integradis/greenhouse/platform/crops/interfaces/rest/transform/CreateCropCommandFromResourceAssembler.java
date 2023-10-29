package com.integradis.greenhouse.platform.crops.interfaces.rest.transform;

import com.integradis.greenhouse.platform.crops.domain.model.commands.CreateCropCommand;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.CreateCropResource;
import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Company;

public class CreateCropCommandFromResourceAssembler {
    public static CreateCropCommand toCommandFromResource(CreateCropResource resource){
        return new CreateCropCommand(resource.companyId());
    }
}
