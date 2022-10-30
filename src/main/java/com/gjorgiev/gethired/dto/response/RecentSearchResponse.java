package com.gjorgiev.gethired.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecentSearchResponse {
    private Long id;
    private List<String> keywords;
    private LocationResponse location;
    private List<JobResponse> results;
}
