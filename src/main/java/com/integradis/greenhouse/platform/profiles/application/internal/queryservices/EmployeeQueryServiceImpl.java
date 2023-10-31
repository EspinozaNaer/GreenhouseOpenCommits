package com.integradis.greenhouse.platform.profiles.application.internal.queryservices;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Employee;
import com.integradis.greenhouse.platform.profiles.domain.model.queries.GetEmployeeByEmailQuery;
import com.integradis.greenhouse.platform.profiles.domain.model.queries.GetEmployeeByIdQuery;
import com.integradis.greenhouse.platform.profiles.domain.model.queries.GetEmployeesByCompanyIdQuery;
import com.integradis.greenhouse.platform.profiles.domain.services.EmployeeQueryService;
import com.integradis.greenhouse.platform.profiles.infrastructure.persistence.jpa.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeQueryServiceImpl implements EmployeeQueryService {
    private final EmployeeRepository employeeRepository;

    public EmployeeQueryServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<Employee> handle(GetEmployeeByIdQuery query) {
        return employeeRepository.findById(query.employeeId());
    }

    @Override
    public Optional<Employee> handle(GetEmployeeByEmailQuery query) {
        return employeeRepository.findByEmail(query.email());
    }

    @Override
    public List<Employee> handle(GetEmployeesByCompanyIdQuery query) {
        return employeeRepository.findAllByCompanyId(query.companyId());
    }
}
