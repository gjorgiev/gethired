package com.gjorgiev.gethired.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CompanyRequest {
    @NotNull(message = "Company Name should not be null")
    private String name;
}
