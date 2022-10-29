package com.gjorgiev.gethired.dto.request;

import lombok.Data;


@Data
public class JobRequest {
    private Long id;
    private String title;
    private String description;
    private Long companyId;
    private boolean remote;
    private Long locationId;
}
