package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CompanyRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CompanyRepository repository;

    @Test
    public void should_find_no_companies_if_repository_is_empty() {
        Iterable<Company> companies = repository.findAll();
        assertThat(companies).isEmpty();
    }
}
