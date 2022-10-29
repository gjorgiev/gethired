package com.gjorgiev.gethired.services;

import com.gjorgiev.gethired.dto.request.LocationRequest;
import com.gjorgiev.gethired.dto.response.LocationResponse;
import com.gjorgiev.gethired.models.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LocationService {
    Page<Location> getLocations(Pageable pageable);
    Location getLocationById(Long locationId);
    Location createLocation(Location location);
    LocationResponse updateLocation(Long locationId, LocationRequest locationRequest);

    void deleteLocation(Long locationId);
}
