package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.exceptions.ApiRequestException;
import com.gjorgiev.gethired.models.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void should_find_company_by_id(){
        Company company1 = new Company();
        company1.setName("Microsoft");
        entityManager.persist(company1);

        Company company2 = new Company();
        company2.setName("Apple");
        entityManager.persist(company2);

        Company company = repository.findCompanyById(company1.getId())
                .orElseThrow(() -> new ApiRequestException("Company with id " + company1.getId() + " not found", HttpStatus.NOT_FOUND));

        assertEquals(company, company1);
    }
}
