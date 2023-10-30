package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import com.integradis.greenhouse.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class Tunnel extends CropEntry {
    @Getter
    private int thermocoupleOne;
    @Getter
    private int thermocoupleTwo;
    @Getter
    private int thermocoupleThree;
    @Getter
    private float averageThermocouple;
    @Getter
    private int motorFrequency;
    @Getter
    private float roomTemperature;
    @Getter
    private int freshAir;
    @Getter
    private int recirculation;
    @Getter
    private String comment;

    public Tunnel() {
        this.cropPhase = CropPhase.TUNNEL;
    }

    public Tunnel(String author, Long nextItemId) {
        super(author, nextItemId);
        this.cropPhase = CropPhase.TUNNEL;
    }
}
