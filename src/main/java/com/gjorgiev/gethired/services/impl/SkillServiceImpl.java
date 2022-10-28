package com.gjorgiev.gethired.services.impl;

import com.gjorgiev.gethired.models.Skill;
import com.gjorgiev.gethired.repositories.SkillRepository;
import com.gjorgiev.gethired.services.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    @Override
    public Page<Skill> getSkills(Pageable pageable) {
        return skillRepository.findAll(pageable);
    }
}
