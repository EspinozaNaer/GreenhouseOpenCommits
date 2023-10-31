package com.integradis.greenhouse.platform.profiles.application.internal.commandservices;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Company;
import com.integradis.greenhouse.platform.profiles.domain.model.commands.CreateCompanyCommand;
import com.integradis.greenhouse.platform.profiles.infrastructure.persistence.jpa.repositories.CompanyRepository;
import com.integradis.greenhouse.platform.profiles.domain.model.valueobjects.CompanyName;
import com.integradis.greenhouse.platform.profiles.domain.services.CompanyCommandService;
import org.springframework.stereotype.Service;

@Service
public class CompanyCommandServiceImpl implements CompanyCommandService {
    private final CompanyRepository companyRepository;

    public CompanyCommandServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @Override
    public Long handle(CreateCompanyCommand command) {
        var companyName = new CompanyName(command.name());
        companyRepository.findByCompanyName(companyName).map(company -> {
            throw new IllegalArgumentException("Company with name " + command.name() + " already exists");
        });
        var company = new Company(command.name(), command.tin());
        companyRepository.save(company);
        return company.getId();
    }
}
