package com.gjorgiev.gethired.services.impl;

import com.gjorgiev.gethired.dto.request.SearchRequest;
import com.gjorgiev.gethired.dto.response.RecentSearchResponse;
import com.gjorgiev.gethired.models.RecentSearch;
import com.gjorgiev.gethired.repositories.RecentSearchRepository;
import com.gjorgiev.gethired.services.RecentSearchService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements RecentSearchService {
    private final RecentSearchRepository recentSearchRepository;
    private final ModelMapper modelMapper;
    @Override
    public Page<RecentSearch> getSearches(Pageable pageable) {
        return recentSearchRepository.findAll(pageable);
    }

    @Override
    public RecentSearchResponse getSearchById(Long searchId) {
        return modelMapper.map(recentSearchRepository.findById(searchId)
                .orElseThrow(), RecentSearchResponse.class);
    }

    @Override
    public List<RecentSearchResponse> getAllByUserId(Long userId) {
        List<RecentSearch> recentSearchList = recentSearchRepository.findAllByUserId(userId);
        return recentSearchList.stream()
                .map(item -> modelMapper.map(item, RecentSearchResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public RecentSearchResponse createRecentSearch(SearchRequest searchRequest) {
        RecentSearch recentSearch = modelMapper.map(searchRequest, RecentSearch.class);
        return modelMapper.map(recentSearchRepository.save(recentSearch), RecentSearchResponse.class);
    }
}
