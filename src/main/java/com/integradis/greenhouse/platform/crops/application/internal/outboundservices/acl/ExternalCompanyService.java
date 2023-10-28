package com.integradis.greenhouse.platform.crops.application.internal.outboundservices.acl;

import com.integradis.greenhouse.platform.profiles.interfaces.acl.CompaniesContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalCompanyService {
    private final CompaniesContextFacade companiesContextFacade;

    public ExternalCompanyService(CompaniesContextFacade companiesContextFacade) {
        this.companiesContextFacade = companiesContextFacade;
    }


}
