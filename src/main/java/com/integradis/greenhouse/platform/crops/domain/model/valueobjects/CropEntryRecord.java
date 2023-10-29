package com.integradis.greenhouse.platform.crops.domain.model.valueobjects;

import com.integradis.greenhouse.platform.crops.domain.model.aggregates.Crop;
import com.integradis.greenhouse.platform.crops.domain.model.entities.*;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class CropEntryRecord {

    @OneToMany(mappedBy = "crop")
    public List<CropEntry> cropEntryList;

    public CropEntryRecord() {
        this.cropEntryList = new ArrayList<>();
    }

    public void addFormulaItem(String author){
        int size = cropEntryList.size();
        Long currentLastItemId = size > 0 ? cropEntryList.get(size - 1).getId() : null;
        Formula formula = new Formula(author, currentLastItemId);
        cropEntryList.add(formula);
    }

    public void addBunkerItem(String author){
        int size = cropEntryList.size();
        Long currentLastItemId = size > 0 ? cropEntryList.get(size - 1).getId() : null;
        Bunker bunker = new Bunker(author, currentLastItemId);
        cropEntryList.add(bunker);
    }

    public void addPreparationAreaItem(String author){
        int size = cropEntryList.size();
        Long currentLastItemId = size > 0 ? cropEntryList.get(size - 1).getId() : null;
        PreparationArea preparationArea = new PreparationArea(author, currentLastItemId);
        cropEntryList.add(preparationArea);
    }

    public void addTunnelItem(String author){
        int size = cropEntryList.size();
        Long currentLastItemId = size > 0 ? cropEntryList.get(size - 1).getId() : null;
        Tunnel tunnel = new Tunnel(author, currentLastItemId);
        cropEntryList.add(tunnel);
    }

    public void addIncubationItem(String author){
        int size = cropEntryList.size();
        Long currentLastItemId = size > 0 ? cropEntryList.get(size - 1).getId() : null;
        GrowRoomRecord growRoomRecord = new GrowRoomRecord(author, currentLastItemId, CropPhase.INCUBATION);
        cropEntryList.add(growRoomRecord);
    }

    public void addCasingItem(String author){
        int size = cropEntryList.size();
        Long currentLastItemId = size > 0 ? cropEntryList.get(size - 1).getId() : null;
        GrowRoomRecord growRoomRecord = new GrowRoomRecord(author, currentLastItemId, CropPhase.CASING);
        cropEntryList.add(growRoomRecord);
    }

    public void addInductionItem(String author){
        int size = cropEntryList.size();
        Long currentLastItemId = size > 0 ? cropEntryList.get(size - 1).getId() : null;
        GrowRoomRecord growRoomRecord = new GrowRoomRecord(author, currentLastItemId, CropPhase.INDUCTION);
        cropEntryList.add(growRoomRecord);
    }

    public void addHarvestItem(String author){
        int size = cropEntryList.size();
        Long currentLastItemId = size > 0 ? cropEntryList.get(size - 1).getId() : null;
        GrowRoomRecord growRoomRecord = new GrowRoomRecord(author, currentLastItemId, CropPhase.HARVEST);
        cropEntryList.add(growRoomRecord);
    }

    private CropEntry getCropEntryWithId(Long itemId){
        return cropEntryList.stream().filter(cropEntry ->
                cropEntry.getId().equals(itemId)).findFirst().orElse(null);
    }

    public List<CropEntry> getCropEntryListWithCropPhase(CropPhase cropPhase){
        return cropEntryList.stream().filter(cropEntry -> cropEntry.getCropPhase().equals(cropPhase)).toList();
    }

    public List<CropEntry> getCropEntryListWithAuthor(String author){
        return cropEntryList.stream().filter(cropEntry -> cropEntry.getAuthor().equals(author)).toList();
    }

    public CropEntry getLastItemInCropRecord(){
        return cropEntryList.stream().filter(cropEntry -> cropEntry.getNextItemId() == null)
                .findFirst().orElse(null);
    }
}
