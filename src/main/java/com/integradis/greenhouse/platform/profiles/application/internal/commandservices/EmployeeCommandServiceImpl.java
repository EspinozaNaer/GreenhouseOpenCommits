package com.integradis.greenhouse.platform.profiles.application.internal.commandservices;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Company;
import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Employee;
import com.integradis.greenhouse.platform.profiles.domain.model.commands.CreateEmployeeCommand;
import com.integradis.greenhouse.platform.profiles.domain.model.valueobjects.Email;
import com.integradis.greenhouse.platform.profiles.domain.services.EmployeeCommandService;
import com.integradis.greenhouse.platform.profiles.infrastructure.persistence.jpa.repositories.repositories.EmployeeRepository;
import com.integradis.greenhouse.platform.profiles.interfaces.acl.CompaniesContextFacade;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCommandServiceImpl implements EmployeeCommandService {
    private final EmployeeRepository employeeRepository;

    private final CompaniesContextFacade companiesContextFacade;

    public EmployeeCommandServiceImpl(EmployeeRepository employeeRepository, CompaniesContextFacade companiesContextFacade) {
        this.employeeRepository = employeeRepository;
        this.companiesContextFacade = companiesContextFacade;
    }


    @Override
    public Long handle(CreateEmployeeCommand command) {
        var email = new Email(command.email());
        employeeRepository.findByEmail(email).map(employee -> {
            throw new IllegalArgumentException("Employee with email" + command.email() + " already exists");
        });
        Company company = companiesContextFacade.getCompanyById(command.companyId()).orElseThrow(() -> new IllegalArgumentException("Company with id " + command.companyId() + " does not exist"));
        var employee = new Employee(command.firstName(), command.lastName(), command.email(), company);
        employeeRepository.save(employee);
        return employee.getId();
    }
}
