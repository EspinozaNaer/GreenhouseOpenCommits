package com.integradis.greenhouse.platform.profiles.infrastructure.persistence.jpa.repositories.repositories;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Employee;
import com.integradis.greenhouse.platform.profiles.domain.model.valueobjects.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(Email email);
}
