package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Location;
import com.gjorgiev.gethired.models.Search;
import com.gjorgiev.gethired.models.User;
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

    @Test
    public void should_find_all_searches_by_user() {
        User user1 = new User();
        user1.setName("John Smith");
        entityManager.persist(user1);

        User user2 = new User();
        user2.setName("Alice");
        entityManager.persist(user2);

        Search search1 = new Search();
        search1.setUser(user1);
        search1.setKeywords("java spring");
        entityManager.persist(search1);

        Search search2 = new Search();
        search2.setUser(user2);
        search2.setKeywords("python django");
        entityManager.persist(search2);


        Iterable<Search> searches = repository.findAllByUser(user1);

        assertThat(searches).hasSize(1).contains(search1);
    }

    @Test
    public void should_find_all_searches_by_keywords(){
        User user1 = new User();
        user1.setName("John Smith");
        entityManager.persist(user1);

        User user2 = new User();
        user2.setName("Alice");
        entityManager.persist(user2);

        Search search1 = new Search();
        search1.setUser(user1);
        search1.setKeywords("java spring");
        entityManager.persist(search1);

        Search search2 = new Search();
        search2.setUser(user2);
        search2.setKeywords("python django");
        entityManager.persist(search2);

        Iterable<Search> searches = repository.findALlByKeywordsContaining("python");

        assertThat(searches).hasSize(1).contains(search2);
    }

    @Test
    public void should_find_all_searches_by_location(){
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

        Search search1 = new Search();
        search1.setUser(user1);
        search1.setKeywords("java spring");
        search1.setLocation(location1);
        entityManager.persist(search1);

        Search search2 = new Search();
        search2.setUser(user2);
        search2.setKeywords("python django");
        search2.setLocation(location2);
        entityManager.persist(search2);

        Iterable<Search> searches = repository.findAllByLocation(location1.getId());

        assertThat(searches).hasSize(1).contains(search1);
    }

}
