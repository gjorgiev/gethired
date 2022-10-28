package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Skill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SkillRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private SkillRepository repository;

    @Test
    public void should_find_no_skills_if_repository_is_empty(){
        Iterable<Skill> skills = repository.findAll();
        assertThat(skills).isEmpty();
    }
}
