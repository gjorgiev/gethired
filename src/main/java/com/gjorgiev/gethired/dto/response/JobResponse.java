package com.gjorgiev.gethired.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobResponse {
    private Long id;
    private String title;
    private String description;
    private Boolean remote;
}
