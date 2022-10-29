package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Skill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class SkillRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private SkillRepository repository;

    @Test
    public void isEmpty(){
        Iterable<Skill> skills = repository.findAll();
        assertThat(skills).isEmpty();
    }

    @Test
    public void findSkillById() throws Exception{
        Skill skill1 = new Skill();
        skill1.setName("Java");
        entityManager.persist(skill1);

        Skill skill2 = new Skill();
        skill2.setName("Python");
        entityManager.persist(skill2);

        Skill skill = repository.findSkillById(skill1.getId()).orElseThrow(() -> new Exception("not found"));

        assertEquals(skill, skill1);
    }
}
