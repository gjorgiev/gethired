package com.gjorgiev.gethired.services.impl;

import com.gjorgiev.gethired.exceptions.ApiRequestException;
import com.gjorgiev.gethired.models.Skill;
import com.gjorgiev.gethired.repositories.SkillRepository;
import com.gjorgiev.gethired.services.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    @Override
    public Page<Skill> getSkills(Pageable pageable) {
        return skillRepository.findAll(pageable);
    }

    @Override
    public Skill getSkillById(Long skillId) {
        return skillRepository.findSkillById(skillId)
                .orElseThrow(() -> new ApiRequestException("Skill with id = " + skillId + " not found", HttpStatus.NOT_FOUND));
    }
}
