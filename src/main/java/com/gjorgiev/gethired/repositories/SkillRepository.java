package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    @Query("SELECT skill FROM Skill skill WHERE skill.id = :skillId")
    Optional<Skill> findSkillById(Long skillId);
}
