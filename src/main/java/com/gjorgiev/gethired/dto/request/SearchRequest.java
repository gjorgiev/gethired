package com.gjorgiev.gethired.dto.request;

import com.gjorgiev.gethired.models.Location;
import com.gjorgiev.gethired.models.User;
import lombok.Data;

import java.util.List;

@Data
public class SearchRequest {
    private List<String> keywords;
    private User user;
}
