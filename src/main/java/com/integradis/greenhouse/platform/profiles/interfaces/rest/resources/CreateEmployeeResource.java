package com.integradis.greenhouse.platform.profiles.interfaces.rest.resources;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Company;

public record CreateEmployeeResource(String firstName, String lastName, String email, Company company) {
}
