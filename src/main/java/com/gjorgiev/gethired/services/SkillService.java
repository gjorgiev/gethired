package com.gjorgiev.gethired.services;

import com.gjorgiev.gethired.models.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SkillService {
    Page<Skill> getSkills(Pageable pageable);
}