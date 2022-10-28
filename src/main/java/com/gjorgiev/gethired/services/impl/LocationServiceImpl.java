package com.gjorgiev.gethired.services.impl;

import com.gjorgiev.gethired.models.Location;
import com.gjorgiev.gethired.repositories.LocationRepository;
import com.gjorgiev.gethired.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    @Override
    public Page<Location> getLocations(Pageable pageable) {
        return locationRepository.findAll(pageable);
    }
}
