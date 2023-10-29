package com.integradis.greenhouse.platform.profiles.interfaces.rest.resources;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Company;

public record EmployeeResource(Long id, String fullName, String email, Company company) {
}
