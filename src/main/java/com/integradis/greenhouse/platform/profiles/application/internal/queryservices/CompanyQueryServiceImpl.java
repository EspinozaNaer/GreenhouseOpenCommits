package com.integradis.greenhouse.platform.profiles.application.internal.queryservices;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Company;
import com.integradis.greenhouse.platform.profiles.domain.model.queries.GetCompanyByCompanyNameQuery;
import com.integradis.greenhouse.platform.profiles.domain.model.queries.GetCompanyByIdQuery;
import com.integradis.greenhouse.platform.profiles.domain.model.queries.GetCompanyByTinQuery;
import com.integradis.greenhouse.platform.profiles.domain.services.CompanyQueryService;
import com.integradis.greenhouse.platform.profiles.infrastructure.persistence.jpa.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyQueryServiceImpl implements CompanyQueryService {

    private final CompanyRepository companyRepository;

    public CompanyQueryServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<Company> handle(GetCompanyByIdQuery query) {
        return companyRepository.findById(query.id());
    }

    @Override
    public Optional<Company> handle(GetCompanyByCompanyNameQuery query) {
        return companyRepository.findByCompanyName(query.companyName());
    }

    @Override
    public Optional<Company> handle(GetCompanyByTinQuery query) {
        return companyRepository.findByTin(query.tin());
    }
}
