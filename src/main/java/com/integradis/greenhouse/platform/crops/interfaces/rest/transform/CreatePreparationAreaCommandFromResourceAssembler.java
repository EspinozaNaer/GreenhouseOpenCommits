package com.integradis.greenhouse.platform.crops.interfaces.rest.transform;

import com.integradis.greenhouse.platform.crops.domain.model.commands.CreatePreparationAreaCommand;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.CreatePreparationAreaResource;

public class CreatePreparationAreaCommandFromResourceAssembler {
    public static CreatePreparationAreaCommand toCommandFromResource(CreatePreparationAreaResource resource){
        return new CreatePreparationAreaCommand(resource.cropId(), resource.author(), resource.activities(),
                resource.temperature(), resource.comment());
    }
}
