package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
