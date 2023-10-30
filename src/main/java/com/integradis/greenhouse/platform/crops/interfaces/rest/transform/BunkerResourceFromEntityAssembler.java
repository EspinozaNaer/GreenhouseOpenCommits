package com.integradis.greenhouse.platform.crops.interfaces.rest.transform;

import com.integradis.greenhouse.platform.crops.domain.model.entities.Bunker;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.BunkerResource;

public class BunkerResourceFromEntityAssembler {
    public static BunkerResource toResourceFromEntity(Bunker entity){
        return new BunkerResource(entity.getId(), entity.getAuthor(), entity.getThermocoupleOne(), entity.getThermocoupleTwo(),
                entity.getThermocoupleThree(), entity.getAverageThermocouple(), entity.getMotorFrequency(), entity.getComment());
    }
}
