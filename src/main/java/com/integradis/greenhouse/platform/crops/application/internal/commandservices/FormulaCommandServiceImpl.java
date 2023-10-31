package com.integradis.greenhouse.platform.crops.application.internal.commandservices;

import com.integradis.greenhouse.platform.crops.domain.exceptions.CropNotFoundException;
import com.integradis.greenhouse.platform.crops.domain.model.commands.CreateFormulaCommand;
import com.integradis.greenhouse.platform.crops.domain.model.entities.Formula;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetCropByIdQuery;
import com.integradis.greenhouse.platform.crops.domain.services.FormulaCommandService;
import com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories.CropRepository;
import com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories.FormulaRepository;
import org.springframework.stereotype.Service;

@Service
public class FormulaCommandServiceImpl implements FormulaCommandService {

    private final FormulaRepository formulaRepository;

    private final CropRepository cropRepository;

    public FormulaCommandServiceImpl(FormulaRepository formulaRepository, CropRepository cropRepository) {
        this.formulaRepository = formulaRepository;
        this.cropRepository = cropRepository;
    }

    @Override
    public Long handle(CreateFormulaCommand command) {
        var getCropByIdQuery = new GetCropByIdQuery(command.cropId());
        var crop = cropRepository.findById(getCropByIdQuery.id()).orElseThrow(() -> new CropNotFoundException(command.cropId()));
        var formula = new Formula(crop, command.author(), command.hay(), command.corn(), command.guano(),
        command.cottonSeedCake(), command.soybeanMeal(), command.gypsum(), command.urea(), command.ammoniumSulphate());
        formulaRepository.save(formula);
        return formula.getId();
    }
}
