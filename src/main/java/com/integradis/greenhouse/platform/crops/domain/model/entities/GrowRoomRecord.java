package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import jakarta.persistence.*;


@Entity
public class GrowRoomRecord extends CropEntry {
    private int grow_room;
    private float air_temperature;
    private String compost_temperature;
    private int carbon_dioxide;
    private int air_humidity;
    private float setting;
    private String comment;

    public GrowRoomRecord(CropPhase phase){
        this.cropPhase = phase;
    }

    public GrowRoomRecord(String author, Long nextItemId, CropPhase phase, Crop crop){
        super(author, nextItemId, crop);
        this.cropPhase = phase;
    }

    public GrowRoomRecord() {

    }
}
