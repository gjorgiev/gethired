package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.RecentSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecentSearchRepository extends JpaRepository<RecentSearch, Long> {
    @Query("SELECT search FROM RecentSearch search " +
            "WHERE search.user.id = :userId")
    List<RecentSearch> findAllByUserId(Long userId);
    @Query("SELECT search FROM RecentSearch search " +
            "LEFT JOIN search.location location " +
            "WHERE location.id = :locationId")
    List<RecentSearch> findAllByLocationId(Long locationId);
}
