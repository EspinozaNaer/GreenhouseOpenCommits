package com.integradis.greenhouse.platform.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;


@Embeddable
public record Tin(String number) {
    public Tin(){this(null);}

}
