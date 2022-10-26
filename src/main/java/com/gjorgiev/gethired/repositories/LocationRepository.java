package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
