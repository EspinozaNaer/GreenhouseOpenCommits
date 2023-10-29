package com.integradis.greenhouse.platform.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record CompanyId(Long companyId) {
    public CompanyId() { this(0L); }

    public CompanyId {
        if (companyId < 0) {
            throw new IllegalArgumentException("Company id cannot be negative");
        }
    }

}
