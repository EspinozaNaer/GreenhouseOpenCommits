package com.integradis.greenhouse.platform.profiles.interfaces.rest.transform;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Employee;
import com.integradis.greenhouse.platform.profiles.interfaces.rest.resources.EmployeeResource;

public class EmployeeResourceFromEntityAssembler {
    public static EmployeeResource toResourceFromEntity(Employee entity) {
        return new EmployeeResource(
            entity.getId(),
            entity.getFullName(),
            entity.getEmail(),
            entity.getCompany().getId()
        );
    }
}
