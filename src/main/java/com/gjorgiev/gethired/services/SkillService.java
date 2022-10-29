package com.gjorgiev.gethired.services;

import com.gjorgiev.gethired.dto.request.SkillRequest;
import com.gjorgiev.gethired.dto.response.SkillResponse;
import com.gjorgiev.gethired.models.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SkillService {
    Page<Skill> getSkills(Pageable pageable);
    Skill getSkillById(Long skillId);

    SkillResponse createSkill(SkillRequest skillRequest);
}
