package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Search;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SearchRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private SearchRepository repository;

    @Test
    public void should_find_no_searches_if_repository_is_empty(){
        Iterable<Search> searches = repository.findAll();
        assertThat(searches).isEmpty();
    }
}
