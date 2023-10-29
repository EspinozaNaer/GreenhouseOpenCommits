package com.integradis.greenhouse.platform.crops.interfaces.rest.transform;

import com.integradis.greenhouse.platform.crops.domain.model.entities.Formula;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.FormulaResource;

public class FormulaResourceFromEntityAssembler {
    public static FormulaResource toResourceFromEntity(Formula entity){
        return new FormulaResource(entity.getId(), entity.getAuthor(), entity.getHay(), entity.getCorn(),
                entity.getGuano(), entity.getCottonSeedCake(), entity.getSoybeanMeal(), entity.getGypsum(),
                entity.getUrea(), entity.getAmmoniumSulphate());
    }
}
