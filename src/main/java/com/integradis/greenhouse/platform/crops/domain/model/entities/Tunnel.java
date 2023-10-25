package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import com.integradis.greenhouse.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class Tunnel extends CropEntry {
    private int thermocoupleOne;
    private int thermocoupleTwo;
    private int thermocoupleThree;
    private float averageThermocouple;
    private int motorFrequency;
    private float roomTemperature;
    private int freshAir;
    private int recirculation;
    private String comment;

    public Tunnel() {
        this.cropPhase = CropPhase.TUNNEL;
    }

    public Tunnel(String author, Long nextItemId) {
        super(author, nextItemId);
        this.cropPhase = CropPhase.TUNNEL;
    }
}
