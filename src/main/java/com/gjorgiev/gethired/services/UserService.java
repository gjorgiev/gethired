package com.gjorgiev.gethired.services;

import com.gjorgiev.gethired.dto.request.SearchRequest;
import com.gjorgiev.gethired.dto.response.RecentSearchResponse;
import com.gjorgiev.gethired.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    Page<User> getUsers(Pageable pageable);
    User getUserById(Long userId);
    List<RecentSearchResponse> getAllRecentSearches(Long userId);
    RecentSearchResponse createRecentSearch(SearchRequest searchRequest);
}
