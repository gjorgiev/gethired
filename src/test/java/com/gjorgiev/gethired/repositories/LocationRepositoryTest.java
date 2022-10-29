package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Location;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class LocationRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private LocationRepository repository;

    @Test
    public void isEmpty(){
        Iterable<Location> locations = repository.findAll();
        assertThat(locations).isEmpty();
    }

    @Test
    public void findLocationById() throws Exception {
        Location location1 = new Location();
        location1.setCity("Los Angeles");
        location1.setCountry("USA");
        entityManager.persist(location1);

        Location location2 = new Location();
        location2.setCity("Berlin");
        location2.setCountry("Germany");
        entityManager.persist(location2);

        Location location = repository.findLocationById(location1.getId()).orElseThrow(() -> new Exception("not found"));

        assertEquals(location, location1);
    }
}
