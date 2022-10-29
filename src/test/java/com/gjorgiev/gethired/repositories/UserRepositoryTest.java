package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Location;
import com.gjorgiev.gethired.models.Skill;
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
    public void isEmpty(){
        Iterable<User> users = repository.findAll();
        assertThat(users).isEmpty();
    }

    @Test
    public void findAllByLocationId(){
        Location location1 = new Location();
        location1.setCity("New York");
        location1.setCountry("USA");
        entityManager.persist(location1);

        Location location2 = new Location();
        location2.setCity("Malmo");
        location2.setCountry("Sweden");
        entityManager.persist(location2);

        User user1 = new User();
        user1.setName("John Smith");
        user1.setLocation(location1);
        entityManager.persist(user1);

        User user2 = new User();
        user2.setName("Alice");
        user2.setLocation(location2);
        entityManager.persist(user2);

        Iterable<User> users = repository.findAllByLocationId(location1.getId());

        assertThat(users).hasSize(1).contains(user1);
    }

    @Test
    public void findAllBySkills(){
        Skill skill1 = new Skill();
        skill1.setName("Java");
        entityManager.persist(skill1);

        Skill skill2 = new Skill();
        skill2.setName("Python");
        entityManager.persist(skill2);

        User user1 = new User();
        user1.setName("John");
        user1.getSkills().add(skill1);
        entityManager.persist(user1);

        User user2 = new User();
        user2.setName("Alice");
        user2.getSkills().add(skill2);
        entityManager.persist(user2);

        Iterable<User> users = repository.findAllBySkills(skill1);

        assertThat(users).hasSize(1).contains(user1);
    }

}
