package com.integradis.greenhouse.platform.crops.domain.model.aggregates;

import com.integradis.greenhouse.platform.crops.domain.model.entities.*;

import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropEntryRecord;
import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Crop extends AbstractAggregateRoot<Crop> {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private Date startDate;
    @LastModifiedDate
    private Date endDate;
    private boolean state;

    public CropPhase cropPhase;

    @Embedded
    @Getter
    public CropEntryRecord cropEntryRecord;

    public Crop(){
    }

    public void start(){
        this.startDate = new Date();
        this.state = true;
        this.cropPhase = CropPhase.FORMULA;
    }

    public void complete(){
        this.endDate = new Date();
        this.state = false;
    }

    public boolean isActive(){
        return this.state;
    }

}
