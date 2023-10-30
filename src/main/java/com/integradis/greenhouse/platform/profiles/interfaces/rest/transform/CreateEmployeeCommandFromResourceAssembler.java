package com.integradis.greenhouse.platform.profiles.interfaces.rest.transform;

import com.integradis.greenhouse.platform.profiles.domain.model.commands.CreateEmployeeCommand;
import com.integradis.greenhouse.platform.profiles.interfaces.rest.resources.CreateEmployeeResource;

public class CreateEmployeeCommandFromResourceAssembler {
    public static CreateEmployeeCommand toCommandFromResource(CreateEmployeeResource resource) {
        return new CreateEmployeeCommand(
            resource.firstName(),
            resource.lastName(),
            resource.email(),
            resource.companyId()
        );
    }
}
