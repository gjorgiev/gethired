package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.exceptions.ApiRequestException;
import com.gjorgiev.gethired.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class JobRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private JobRepository repository;

    @Test
    public void should_find_no_jobs_if_repository_is_empty() {
        Iterable<Job> jobs = repository.findAll();
        assertThat(jobs).isEmpty();
    }

    @Test
    public void should_find_job_by_id(){
        Company company = new Company();
        company.setName("Microsoft");
        entityManager.persist(company);

        Job job1 = new Job();
        job1.setTitle("Java Developer");
        job1.setCompany(company);
        entityManager.persist(job1);

        Job job2 = new Job();
        job2.setTitle("Python Developer");
        job2.setCompany(company);
        entityManager.persist(job2);

        Job job = repository.findJobById(job1.getId())
                .orElseThrow(() -> new ApiRequestException("Job with id: " + job1.getId() + " not found", HttpStatus.NOT_FOUND));

        assertEquals(job, job1);
    }

    @Test
    public void should_find_all_jobs_by_title_or_description_containing_string() throws Exception {
        Company company = new Company();
        company.setName("Microsoft");
        entityManager.persist(company);

        Location location = new Location();
        location.setCity("New York");
        location.setCountry("USA");
        entityManager.persist(location);

        Job job1 = new Job("Java Developer", "Working with Java an Spring Framework", company, true, location);
        entityManager.persist(job1);
        Job job2 = new Job("Python Developer", "Working with Python an Django Framework", company, true, location);
        entityManager.persist(job2);

        List<Job> jobs = repository.search("java");

        assertThat(jobs).hasSize(1).contains(job1);
    }

    @Test
    public void should_find_all_jobs_by_company() throws Exception {
        Company company = new Company();
        company.setName("Microsoft");
        entityManager.persist(company);

        Location location = new Location();
        location.setCity("New York");
        location.setCountry("USA");
        entityManager.persist(location);

        Job job1 = new Job("Java Developer", "Working with Java an Spring Framework", company, true, location);
        entityManager.persist(job1);
        Job job2 = new Job("Python Developer", "Working with Python an Django Framework", company, false, location);
        entityManager.persist(job2);
        Job job3 = new Job("Scala Developer", "Working with Scala an Play Framework", company, true, location);
        entityManager.persist(job3);

        List<Job> jobs = repository.findAllByCompany(company);

        assertThat(jobs).hasSize(3).contains(job1, job2, job3);
    }

    @Test
    public void should_find_all_remote_jobs() throws Exception {
        Company company = new Company();
        company.setName("Microsoft");
        entityManager.persist(company);

        Location location = new Location();
        location.setCity("New York");
        location.setCountry("USA");
        entityManager.persist(location);

        Job job1 = new Job("Java Developer", "Working with Java an Spring Framework", company, true, location);
        entityManager.persist(job1);
        Job job2 = new Job("Python Developer", "Working with Python an Django Framework", company, false, location);
        entityManager.persist(job2);
        Job job3 = new Job("Scala Developer", "Working with Scala an Play Framework", company, true, location);
        entityManager.persist(job3);

        List<Job> jobs = repository.findByRemote(true);

        assertThat(jobs).hasSize(2).contains(job1, job3);
    }

    @Test
    public void should_find_all_jobs_by_skill(){
        Skill skill1 = new Skill();
        skill1.setName("Java");
        entityManager.persist(skill1);

        Skill skill2 = new Skill();
        skill2.setName("Python");
        entityManager.persist(skill2);

        Skill skill3 = new Skill();
        skill3.setName("Scala");
        entityManager.persist(skill3);

        Company company = new Company();
        company.setName("Microsoft");
        entityManager.persist(company);

        Location location = new Location();
        location.setCity("New York");
        location.setCountry("USA");
        entityManager.persist(location);

        Job job1 = new Job("Java Developer", "Working with Java an Spring Framework", company, true, location);
        job1.getSkills().add(skill1);
        entityManager.persist(job1);
        Job job2 = new Job("Python Developer", "Working with Python an Django Framework", company, false, location);
        job2.getSkills().add(skill2);
        entityManager.persist(job2);
        Job job3 = new Job("Scala Developer", "Working with Scala an Play Framework", company, true, location);
        job3.getSkills().add(skill3);
        entityManager.persist(job3);

        List<Job> jobs = repository.findAllBySkills(skill1);

        assertThat(jobs).hasSize(1).contains(job1);
    }

    @Test
    public void should_find_all_jobs_by_location(){
        Location location1 = new Location();
        location1.setCity("New York");
        location1.setCountry("USA");
        entityManager.persist(location1);

        Location location2 = new Location();
        location2.setCity("Malmo");
        location2.setCountry("Sweden");
        entityManager.persist(location2);

        Company company = new Company();
        company.setName("Microsoft");
        entityManager.persist(company);

        Job job1 = new Job();
        job1.setTitle("Java Developer");
        job1.setDescription("Working with Java an Spring Framework");
        job1.setCompany(company);
        job1.setLocation(location1);
        entityManager.persist(job1);

        Job job2 = new Job();
        job2.setTitle("Python Developer");
        job2.setDescription("Working with Python an Django Framework");
        job2.setCompany(company);
        job2.setLocation(location2);
        entityManager.persist(job2);

        Job job3 = new Job();
        job3.setTitle("Scala Developer");
        job3.setDescription("Working with Scala an Play Framework");
        job3.setCompany(company);
        job3.setLocation(location1);
        entityManager.persist(job3);

        Iterable<Job> jobs = repository.findAllByLocation(location1);

        assertThat(jobs).hasSize(2).contains(job1, job3);
    }
}
