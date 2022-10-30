package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Location;
import com.gjorgiev.gethired.models.RecentSearch;
import com.gjorgiev.gethired.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RecentSearchRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private RecentSearchRepository repository;

    @Test
    public void isEmpty(){
        Iterable<RecentSearch> searches = repository.findAll();
        assertThat(searches).isEmpty();
    }

    @Test
    public void findAllByUserId() {
        User user1 = new User();
        user1.setName("John Smith");
        entityManager.persist(user1);

        User user2 = new User();
        user2.setName("Alice");
        entityManager.persist(user2);

        RecentSearch recentSearch1 = new RecentSearch();
        recentSearch1.setUser(user1);
        recentSearch1.setKeywords(List.of("java","spring"));
        entityManager.persist(recentSearch1);

        RecentSearch recentSearch2 = new RecentSearch();
        recentSearch2.setUser(user2);
        recentSearch2.setKeywords(List.of("python", "django"));
        entityManager.persist(recentSearch2);


        Iterable<RecentSearch> searches = repository.findAllByUserId(user1.getId());

        assertThat(searches).hasSize(1).contains(recentSearch1);
    }

    @Test
    public void findAllByLocationId(){
        User user1 = new User();
        user1.setName("John Smith");
        entityManager.persist(user1);

        User user2 = new User();
        user2.setName("Alice");
        entityManager.persist(user2);

        Location location1 = new Location();
        location1.setCity("New York");
        location1.setCountry("USA");
        entityManager.persist(location1);

        Location location2 = new Location();
        location2.setCity("Malmo");
        location2.setCountry("Sweden");
        entityManager.persist(location2);

        RecentSearch recentSearch1 = new RecentSearch();
        recentSearch1.setUser(user1);
        recentSearch1.setKeywords(List.of("java","spring"));
        recentSearch1.setLocation(location1);
        entityManager.persist(recentSearch1);

        RecentSearch recentSearch2 = new RecentSearch();
        recentSearch2.setUser(user2);
        recentSearch2.setKeywords(List.of("python", "django"));
        recentSearch2.setLocation(location2);
        entityManager.persist(recentSearch2);

        Iterable<RecentSearch> searches = repository.findAllByLocationId(location1.getId());

        assertThat(searches).hasSize(1).contains(recentSearch1);
    }

}
