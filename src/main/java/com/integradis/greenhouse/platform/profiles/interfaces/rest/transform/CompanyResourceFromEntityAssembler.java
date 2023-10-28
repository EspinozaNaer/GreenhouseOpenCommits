package com.integradis.greenhouse.platform.profiles.interfaces.rest.transform;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Company;
import com.integradis.greenhouse.platform.profiles.interfaces.rest.resources.CompanyResource;

public class CompanyResourceFromEntityAssembler {
    public static CompanyResource toResourceFromEntity(Company entity){
        return new CompanyResource(entity.getId(), entity.getCompanyName(), entity.getTin());
    }
}
