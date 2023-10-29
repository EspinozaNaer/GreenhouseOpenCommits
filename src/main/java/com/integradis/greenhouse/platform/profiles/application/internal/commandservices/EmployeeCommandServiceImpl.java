package com.integradis.greenhouse.platform.profiles.application.internal.commandservices;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Employee;
import com.integradis.greenhouse.platform.profiles.domain.model.commands.CreateEmployeeCommand;
import com.integradis.greenhouse.platform.profiles.domain.model.valueobjects.Email;
import com.integradis.greenhouse.platform.profiles.domain.services.EmployeeCommandService;
import com.integradis.greenhouse.platform.profiles.infrastructure.persistence.jpa.repositories.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCommandServiceImpl implements EmployeeCommandService {
    private final EmployeeRepository employeeRepository;

    public EmployeeCommandServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Long handle(CreateEmployeeCommand command) {
        var email = new Email(command.email());
        employeeRepository.findByEmail(email).map(employee -> {
            throw new IllegalArgumentException("Employee with email" + command.email() + " already exists");
        });
        var employee = new Employee(command.firstName(), command.lastName(), command.email(), command.company());
        employeeRepository.save(employee);
        return employee.getId();
    }
}
