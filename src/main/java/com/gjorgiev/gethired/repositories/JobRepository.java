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
    @Query("SELECT job FROM Job job " +
            "WHERE UPPER(job.title) LIKE UPPER(CONCAT('%',:keyword,'%')) " +
            "or UPPER(job.description) LIKE UPPER(CONCAT('%',:keyword,'%'))")
    List<Job> searchByKeyword(@Param("keyword") String keyword);
    List<Job> findAllByCompany(Company company);
    List<Job> findByRemote(boolean remote);
    List<Job> findAllBySkills(Skill skill);
    List<Job> findAllByLocation(Location location);
    @Query("SELECT job FROM Job job WHERE job.id = :jobId")
    Optional<Job> findJobById(Long jobId);
}
