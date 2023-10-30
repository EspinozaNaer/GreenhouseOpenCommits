package com.integradis.greenhouse.platform.crops.interfaces.rest.transform;

import com.integradis.greenhouse.platform.crops.domain.model.commands.CreateFormulaCommand;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.CreateFormulaResource;

public class CreateFormulaCommandFromResourceAssembler {
    public static CreateFormulaCommand toCommandFromResource(CreateFormulaResource resource){
        return new CreateFormulaCommand(resource.cropId(), resource.author(), resource.hay(), resource.corn(),
                resource.guano(), resource.cottonSeedCake(), resource.soybeanMeal(), resource.gypsum(),
                resource.urea(), resource.ammoniumSulphate());
    }
}
