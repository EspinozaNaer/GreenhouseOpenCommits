package com.integradis.greenhouse.platform.crops.interfaces.rest;

import com.integradis.greenhouse.platform.crops.domain.model.queries.GetBunkerEntriesByCropIdQuery;
import com.integradis.greenhouse.platform.crops.domain.services.BunkerQueryService;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.BunkerResource;
import com.integradis.greenhouse.platform.crops.interfaces.rest.transform.BunkerResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bunker")
@Tag(name = "Bunker", description = "Bunker Management Endpoints")
public class BunkerController {
    private final BunkerQueryService bunkerQueryService;

    public BunkerController(BunkerQueryService bunkerQueryService) {
        this.bunkerQueryService = bunkerQueryService;
    }

    @GetMapping("/{cropId}/bunker")
    public ResponseEntity<List<BunkerResource>> getBunkerEntriesByCropId(@PathVariable Long cropId){
        var getBunkerEntriesByCropId = new GetBunkerEntriesByCropIdQuery(cropId);
        var entries = bunkerQueryService.handle(getBunkerEntriesByCropId);
        if (entries.isEmpty()) return ResponseEntity.badRequest().build();
        var bunkerResource = entries.stream().map((BunkerResourceFromEntityAssembler::toResourceFromEntity)).toList();
        return ResponseEntity.ok(bunkerResource);
    }
}
