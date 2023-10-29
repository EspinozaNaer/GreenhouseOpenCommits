package com.integradis.greenhouse.platform.crops.application.internal.outboundservices.acl;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Company;
import com.integradis.greenhouse.platform.profiles.interfaces.acl.CompaniesContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalCompanyService {
    private final CompaniesContextFacade companiesContextFacade;

    public ExternalCompanyService(CompaniesContextFacade companiesContextFacade) {
        this.companiesContextFacade = companiesContextFacade;
    }

    public Optional<Company> fetchCompanyById(Long id){
        return companiesContextFacade.getCompanyById(id);
    }

    public Optional<Company> fetchCompanyByCompanyName(String name){
        var companyId = companiesContextFacade.getCompanyIdByCompanyName(name);
        if (companyId == 0L) return Optional.empty();
        return Optional.of(new Company(companyId));
    }

}
