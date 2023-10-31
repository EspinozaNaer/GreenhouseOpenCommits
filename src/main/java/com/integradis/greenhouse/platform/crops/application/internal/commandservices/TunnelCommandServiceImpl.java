package com.integradis.greenhouse.platform.crops.application.internal.commandservices;

import com.integradis.greenhouse.platform.crops.domain.exceptions.CropNotFoundException;
import com.integradis.greenhouse.platform.crops.domain.model.commands.CreateTunnelCommand;
import com.integradis.greenhouse.platform.crops.domain.model.entities.Tunnel;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetCropByIdQuery;
import com.integradis.greenhouse.platform.crops.domain.services.TunnelCommandService;
import com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories.CropRepository;
import com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories.TunnelRepository;
import org.springframework.stereotype.Service;

@Service
public class TunnelCommandServiceImpl implements TunnelCommandService {

    private final TunnelRepository tunnelRepository;
    private final CropRepository cropRepository;

    public TunnelCommandServiceImpl(TunnelRepository tunnelRepository, CropRepository cropRepository) {
        this.tunnelRepository = tunnelRepository;
        this.cropRepository = cropRepository;
    }

    @Override
    public Long handle(CreateTunnelCommand command) {
        var getCropByIdQuery = new GetCropByIdQuery(command.cropId());
        var crop = cropRepository.findById(getCropByIdQuery.id()).orElseThrow(() -> new CropNotFoundException(command.cropId()));
        var tunnel = new Tunnel(crop, command.author(), command.thermocoupleOne(), command.thermocoupleTwo(), command.thermocoupleThree(), command.averageThermocouple(), command.motorFrequency(), command.roomTemperature(), command.freshAir(), command.recirculation(), command.comment());
        tunnelRepository.save(tunnel);
        return tunnel.getId();
    }
}
