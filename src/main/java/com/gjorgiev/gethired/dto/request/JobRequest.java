package com.gjorgiev.gethired.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class JobRequest {
    @NotNull(message = "Job title must not be null")
    private String title;
    private String description;
    @NotNull(message = "Job must have a company")
    private CompanyRequest companyRequest;
    @NotNull(message = "Job must have remote true/false")
    private Boolean remote;
    private LocationRequest locationRequest;
}
