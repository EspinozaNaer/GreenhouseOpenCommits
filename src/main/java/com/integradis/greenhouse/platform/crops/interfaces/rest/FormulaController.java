package com.integradis.greenhouse.platform.crops.interfaces.rest;

import com.integradis.greenhouse.platform.crops.domain.model.queries.GetCropsByCompanyId;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetFormulaEntriesByCropId;
import com.integradis.greenhouse.platform.crops.domain.services.FormulaQueryService;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.CropResource;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.FormulaResource;
import com.integradis.greenhouse.platform.crops.interfaces.rest.transform.CropResourceFromEntityAssembler;
import com.integradis.greenhouse.platform.crops.interfaces.rest.transform.FormulaResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crops")
@Tag(name = "Formula", description = "Formula Management Endpoints")
public class FormulaController {

    private final FormulaQueryService formulaQueryService;

    public FormulaController(FormulaQueryService formulaQueryService) {
        this.formulaQueryService = formulaQueryService;
    }

    @GetMapping("/{cropId}/formula")
    public ResponseEntity<List<FormulaResource>> getFormulaEntriesByCropId(@PathVariable Long cropId){
        var getFormulaEntriesByCropId = new GetFormulaEntriesByCropId(cropId);
        var entries = formulaQueryService.handle(getFormulaEntriesByCropId);
        if (entries.isEmpty()) return ResponseEntity.badRequest().build();
        var formulaResource = entries.stream().map((FormulaResourceFromEntityAssembler::toResourceFromEntity)).toList();
        return ResponseEntity.ok(formulaResource);
    }
}
