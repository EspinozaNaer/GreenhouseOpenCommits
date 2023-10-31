package com.integradis.greenhouse.platform.profiles.application.internal.commandservices;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Employee;
import com.integradis.greenhouse.platform.profiles.domain.model.commands.CreateEmployeeCommand;
import com.integradis.greenhouse.platform.profiles.domain.model.queries.GetCompanyByIdQuery;
import com.integradis.greenhouse.platform.profiles.domain.model.valueobjects.Email;
import com.integradis.greenhouse.platform.profiles.domain.services.CompanyQueryService;
import com.integradis.greenhouse.platform.profiles.domain.services.EmployeeCommandService;
import com.integradis.greenhouse.platform.profiles.infrastructure.persistence.jpa.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCommandServiceImpl implements EmployeeCommandService {
    private final EmployeeRepository employeeRepository;
    private final CompanyQueryService companyQueryService;

    public EmployeeCommandServiceImpl(EmployeeRepository employeeRepository, CompanyQueryService companyQueryService) {
        this.employeeRepository = employeeRepository;
        this.companyQueryService = companyQueryService;
    }


    @Override
    public Long handle(CreateEmployeeCommand command) {
        var email = new Email(command.email());
        employeeRepository.findByEmail(email).map(employee -> {
            throw new IllegalArgumentException("Employee with email" + command.email() + " already exists");
        });

        var getCompanyByIdQuery = new GetCompanyByIdQuery(command.companyId());
        var company = companyQueryService.handle(getCompanyByIdQuery).orElseThrow(() -> new IllegalArgumentException("Company with id " + command.companyId() + " does not exist"));
        var employee = new Employee(command.firstName(), command.lastName(), command.email(), company);
        employeeRepository.save(employee);
        return employee.getId();
    }
}
