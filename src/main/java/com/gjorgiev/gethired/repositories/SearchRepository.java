package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<Search, Long> {
}
