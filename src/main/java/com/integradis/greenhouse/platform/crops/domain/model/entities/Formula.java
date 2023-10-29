package com.integradis.greenhouse.platform.crops.domain.model.entities;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class Formula extends CropEntry {

    @Getter
    private int hay;

    @Getter
    private int corn;

    @Getter
    private int guano;

    @Getter
    private float cottonSeedCake;

    @Getter
    private int soybeanMeal;

    @Getter
    private float gypsum;

    @Getter
    private int urea;

    @Getter
    private int ammoniumSulphate;

    public Formula(){
        this.cropPhase = CropPhase.FORMULA;
    }

    public Formula(String author, Long nextItemId){
        super(author, nextItemId);
        this.cropPhase = CropPhase.FORMULA;
    }
}
