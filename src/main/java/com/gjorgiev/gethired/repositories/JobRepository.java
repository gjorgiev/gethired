package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job j " +
            "WHERE UPPER(j.title) LIKE UPPER(CONCAT('%',:keywords,'%')) " +
            "or UPPER(j.description) LIKE UPPER(CONCAT('%',:keywords,'%'))")
    List<Job> search(@Param("keywords") String keywords);
    List<Job> findByCompanyNameIgnoreCase(String companyName);
    List<Job> findByRemote(boolean remote);
}
