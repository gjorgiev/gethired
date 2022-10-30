package com.gjorgiev.gethired.services.impl;

import com.gjorgiev.gethired.dto.request.SkillRequest;
import com.gjorgiev.gethired.dto.response.SkillResponse;
import com.gjorgiev.gethired.exceptions.ApiRequestException;
import com.gjorgiev.gethired.models.Skill;
import com.gjorgiev.gethired.repositories.SkillRepository;
import com.gjorgiev.gethired.services.SkillService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final ModelMapper modelMapper;
    @Override
    public Page<Skill> getSkills(Pageable pageable) {
        return skillRepository.findAll(pageable);
    }

    @Override
    public Skill getSkillById(Long skillId) {
        return skillRepository.findSkillById(skillId)
                .orElseThrow(() -> new ApiRequestException("Skill with id = " + skillId + " not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public SkillResponse createSkill(SkillRequest skillRequest) {
        //TODO: implement create skill
        return null;
    }

    @Override
    public SkillResponse updateSkill(Long skillId, SkillRequest skillRequest) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new ApiRequestException("Skill not found", HttpStatus.NOT_FOUND));
        skill.setName(skillRequest.getName());
        skill.setDescription(skillRequest.getDescription());
        return modelMapper.map(skillRepository.save(skill), SkillResponse.class);
    }

    @Override
    public void deleteSkill(Long skillId) {
        skillRepository.deleteById(skillId);
    }
}
