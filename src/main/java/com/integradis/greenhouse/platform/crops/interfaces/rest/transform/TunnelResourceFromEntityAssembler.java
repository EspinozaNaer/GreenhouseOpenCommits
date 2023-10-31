package com.integradis.greenhouse.platform.crops.interfaces.rest.transform;

import com.integradis.greenhouse.platform.crops.domain.model.entities.Tunnel;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.TunnelResource;

public class TunnelResourceFromEntityAssembler {
    public static TunnelResource toResourceFromEntity(Tunnel entity){
        return new TunnelResource(entity.getId(), entity.getAuthor(), entity.getThermocoupleOne(), entity.getThermocoupleTwo(), entity.getThermocoupleThree(), entity.getAverageThermocouple(), entity.getMotorFrequency(), entity.getRoomTemperature(), entity.getFreshAir(), entity.getRecirculation(), entity.getComment());
    }
}
