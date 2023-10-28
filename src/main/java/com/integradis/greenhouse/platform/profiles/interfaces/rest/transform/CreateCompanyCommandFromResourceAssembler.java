package com.integradis.greenhouse.platform.profiles.interfaces.rest.transform;

import com.integradis.greenhouse.platform.profiles.domain.model.commands.CreateCompanyCommand;
import com.integradis.greenhouse.platform.profiles.interfaces.rest.resources.CreateCompanyResource;

public class CreateCompanyCommandFromResourceAssembler {
    public static CreateCompanyCommand toCommandFromResource(CreateCompanyResource resource){
        return new CreateCompanyCommand(resource.companyName(), resource.Tin());
    }
}
