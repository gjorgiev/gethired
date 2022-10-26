package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Company;
import com.gjorgiev.gethired.models.Job;
import com.gjorgiev.gethired.models.Location;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


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
    public void should_find_jobs_by_title_or_description_containing_string() throws Exception {
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
    public void should_find_by_company_name() throws Exception {
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

        List<Job> jobs = repository.findByCompanyNameIgnoreCase("microsoft");

        assertThat(jobs).hasSize(3).contains(job1, job2, job3);
    }

    @Test
    public void should_find_remote_jobs() throws Exception {
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
}
