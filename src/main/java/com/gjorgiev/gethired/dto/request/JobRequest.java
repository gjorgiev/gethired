package com.gjorgiev.gethired.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class JobRequest {
    @NotNull(message = "Job title must not be null")
    private String title;
    private String description;
    private CompanyRequest companyRequest;
    private boolean remote;
    private LocationRequest locationRequest;
}
