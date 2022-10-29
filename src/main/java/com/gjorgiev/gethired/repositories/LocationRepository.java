package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("SELECT location FROM Location location WHERE location.id = :locationId")
    Optional<Location> findLocationById(Long locationId);
}
