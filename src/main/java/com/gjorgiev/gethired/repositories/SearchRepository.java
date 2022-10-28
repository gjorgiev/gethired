package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Search;
import com.gjorgiev.gethired.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {
    List<Search> findAllByUser(User user);

    List<Search> findALlByKeywordsContaining(String python);
    @Query("SELECT search FROM Search search " +
            "LEFT JOIN search.location location " +
            "WHERE location.id = :locationId")
    List<Search> findAllByLocation(Long locationId);
}
