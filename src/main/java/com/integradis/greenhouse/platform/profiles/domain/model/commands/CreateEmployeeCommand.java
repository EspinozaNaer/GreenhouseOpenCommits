package com.integradis.greenhouse.platform.profiles.domain.model.commands;


import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Company;

public record CreateEmployeeCommand(String firstName, String lastName, String email, Company company) {
}
