package com.gjorgiev.gethired.services.impl;

import com.gjorgiev.gethired.models.Search;
import com.gjorgiev.gethired.repositories.SearchRepository;
import com.gjorgiev.gethired.services.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final SearchRepository searchRepository;
    @Override
    public Page<Search> getSearches(Pageable pageable) {
        return searchRepository.findAll(pageable);
    }
}
