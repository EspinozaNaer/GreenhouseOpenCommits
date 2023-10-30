package com.integradis.greenhouse.platform.crops.application.internal.commandservices;

import com.integradis.greenhouse.platform.crops.application.internal.outboundservices.acl.ExternalCompanyService;
import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.crops.domain.model.commands.CreateCropCommand;
import com.integradis.greenhouse.platform.crops.domain.services.CropCommandService;
import com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories.CropRepository;
import com.integradis.greenhouse.platform.profiles.domain.exceptions.CompanyNotFoundException;
import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Company;
import org.springframework.stereotype.Service;


@Service
public class CropCommandServiceImpl implements CropCommandService {
    private final ExternalCompanyService externalCompanyService;
    private final CropRepository cropRepository;


    public CropCommandServiceImpl(ExternalCompanyService externalCompanyService, CropRepository cropRepository) {
        this.externalCompanyService = externalCompanyService;
        this.cropRepository = cropRepository;
    }

    @Override
    public Long handle(CreateCropCommand command) {
        Company company = externalCompanyService.fetchCompanyById(command.companyId())
                .orElseThrow(() -> new CompanyNotFoundException(command.companyId()));
        Crop crop = new Crop(company);
        cropRepository.save(crop);
        return crop.getId();
    }

}
