package com.integradis.greenhouse.platform.profiles.domain.services;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Employee;
import com.integradis.greenhouse.platform.profiles.domain.model.queries.GetEmployeeByEmailQuery;
import com.integradis.greenhouse.platform.profiles.domain.model.queries.GetEmployeeByIdQuery;

import java.util.Optional;

public interface EmployeeQueryService {
    Optional<Employee> handle(GetEmployeeByIdQuery query);
    Optional<Employee> handle(GetEmployeeByEmailQuery query);
}
