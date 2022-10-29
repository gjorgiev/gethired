package com.gjorgiev.gethired.controllers;

import com.gjorgiev.gethired.dto.request.SkillRequest;
import com.gjorgiev.gethired.dto.response.SkillResponse;
import com.gjorgiev.gethired.models.Skill;
import com.gjorgiev.gethired.services.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/skills")
public class SkillController {
    private final SkillService skillService;

    @GetMapping
    public ResponseEntity<Page<Skill>> getSkills(@PageableDefault(size = 10)Pageable pageable){
        return ResponseEntity.ok(skillService.getSkills(pageable));
    }

    @GetMapping("/{skillId}")
    public ResponseEntity<Skill> getSkillById(@PathVariable Long skillId){
        return ResponseEntity.ok(skillService.getSkillById(skillId));
    }

    @PostMapping
    public ResponseEntity<SkillResponse> createSkill(@RequestBody SkillRequest skillRequest){
        return ResponseEntity.ok(skillService.createSkill(skillRequest));
    }
}
