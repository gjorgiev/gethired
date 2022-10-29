package com.gjorgiev.gethired.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SkillRequest {
    @NotNull(message = "Name cannot be null")
    private String name;
    private String description;
}
