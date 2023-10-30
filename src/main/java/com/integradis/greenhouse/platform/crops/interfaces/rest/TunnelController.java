package com.integradis.greenhouse.platform.crops.interfaces.rest;

import com.integradis.greenhouse.platform.crops.domain.model.queries.GetTunnelEntriesByCropIdQuery;
import com.integradis.greenhouse.platform.crops.domain.services.TunnelQueryService;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.TunnelResource;
import com.integradis.greenhouse.platform.crops.interfaces.rest.transform.TunnelResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tunnel")
@Tag(name = "Tunnel", description = "Tunnel Management Endpoints")
public class TunnelController {
    private final TunnelQueryService tunnelQueryService;

    public TunnelController(TunnelQueryService tunnelQueryService) {
        this.tunnelQueryService = tunnelQueryService;
    }

    @GetMapping("{cropId}/tunnel")
    public ResponseEntity<List<TunnelResource>> getTunnelEntriesByCropId(@PathVariable Long cropId){
        var getTunnelEntriesByCropId = new GetTunnelEntriesByCropIdQuery(cropId);
        var entries = tunnelQueryService.handle(getTunnelEntriesByCropId);
        if (entries.isEmpty()) return ResponseEntity.badRequest().build();
        var tunnelResource = entries.stream().map((TunnelResourceFromEntityAssembler::toResourceFromEntity)).toList();
        return ResponseEntity.ok(tunnelResource);
    }
}
