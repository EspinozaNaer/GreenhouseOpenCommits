package com.integradis.greenhouse.platform.crops.interfaces.rest.resources;

import java.time.LocalDate;

public record FormulaResource(
        Long formulaId,
        String author,
        int hay,
        int corn,
        int guano,
        float cottonSeedCake,
        int soybeanMeal,
        float gypsum,
        int urea,
        int ammoniumSulphate) {
}
