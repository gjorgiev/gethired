package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository repository;

    @Test
    public void should_find_no_locations_if_repository_is_empty(){
        Iterable<User> users = repository.findAll();
        assertThat(users).isEmpty();
    }
}
