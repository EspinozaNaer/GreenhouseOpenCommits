package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class PreparationArea extends CropEntry{
    @Getter
    private int activities;
    @Getter
    private int temperature;
    @Getter
    private String comment;

    public PreparationArea() {
        this.cropPhase = CropPhase.PREPARATION_AREA;
    }

    public PreparationArea(String author, Long nextItemId){
        super(author, nextItemId);
        this.cropPhase = CropPhase.PREPARATION_AREA;
    }
}
