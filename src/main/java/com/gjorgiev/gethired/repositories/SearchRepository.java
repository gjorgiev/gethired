package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {
    @Query("SELECT search FROM Search search " +
            "WHERE search.user.id = :userId")
    List<Search> findAllByUserId(Long userId);

    List<Search> findALlByKeywordsContaining(String keywords);
    @Query("SELECT search FROM Search search " +
            "LEFT JOIN search.location location " +
            "WHERE location.id = :locationId")
    List<Search> findAllByLocationId(Long locationId);
}
