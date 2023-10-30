package com.integradis.greenhouse.platform.crops.interfaces.rest;

import com.integradis.greenhouse.platform.crops.domain.model.queries.GetPreparationAreaEntriesByCropIdQuery;
import com.integradis.greenhouse.platform.crops.domain.services.PreparationAreaQueryService;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.PreparationAreaResource;
import com.integradis.greenhouse.platform.crops.interfaces.rest.transform.PreparationAreaResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/preparationArea")
@Tag(name = "Preparation Area", description = "Preparation Area Management Endpoints")
public class PreparationAreaController {

    private final PreparationAreaQueryService preparationAreaQueryService;

    public PreparationAreaController(PreparationAreaQueryService preparationAreaQueryService) {
        this.preparationAreaQueryService = preparationAreaQueryService;
    }

    @GetMapping("/{cropId}/preparationArea")
    public ResponseEntity<List<PreparationAreaResource>> getPreparationAreaEntriesByCropId(@PathVariable Long cropId){
        var getPreparationAreaEntriesByCropId = new GetPreparationAreaEntriesByCropIdQuery(cropId);
        var entries = preparationAreaQueryService.handle(getPreparationAreaEntriesByCropId);
        if (entries.isEmpty()) return ResponseEntity.badRequest().build();
        var preparationAreaResource = entries.stream().map((PreparationAreaResourceFromEntityAssembler::toResourceFromEntity)).toList();
        return ResponseEntity.ok(preparationAreaResource);
    }

}
