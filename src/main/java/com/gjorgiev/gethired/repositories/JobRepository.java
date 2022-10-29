package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Company;
import com.gjorgiev.gethired.models.Job;
import com.gjorgiev.gethired.models.Location;
import com.gjorgiev.gethired.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job j " +
            "WHERE UPPER(j.title) LIKE UPPER(CONCAT('%',:keywords,'%')) " +
            "or UPPER(j.description) LIKE UPPER(CONCAT('%',:keywords,'%'))")
    List<Job> search(@Param("keywords") String keywords);
    List<Job> findAllByCompany(Company company);
    List<Job> findByRemote(boolean remote);
    List<Job> findAllBySkills(Skill skill);
    List<Job> findAllByLocation(Location location);
    @Query("SELECT job FROM Job job WHERE job.id = :jobId")
    Optional<Job> findJobById(Long jobId);
}
