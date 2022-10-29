package com.gjorgiev.gethired.controllers;

import com.gjorgiev.gethired.models.Location;
import com.gjorgiev.gethired.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<Page<Location>> getLocations(@PageableDefault(size = 10)Pageable pageable){
        return ResponseEntity.ok(locationService.getLocations(pageable));
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long locationId){
        return ResponseEntity.ok(locationService.getLocationById(locationId));
    }
}
