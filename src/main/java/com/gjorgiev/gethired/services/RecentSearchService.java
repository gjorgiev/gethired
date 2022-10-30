package com.gjorgiev.gethired.services;

import com.gjorgiev.gethired.dto.request.SearchRequest;
import com.gjorgiev.gethired.dto.response.RecentSearchResponse;
import com.gjorgiev.gethired.models.RecentSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecentSearchService {
    Page<RecentSearch> getSearches(Pageable pageable);
    RecentSearchResponse getSearchById(Long searchId);
    List<RecentSearchResponse> getAllByUserId(Long userId);
    RecentSearchResponse createRecentSearch(SearchRequest searchRequest);
}
