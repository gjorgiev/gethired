package com.gjorgiev.gethired.services;

import com.gjorgiev.gethired.models.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchService {
    Page<Search> getSearches(Pageable pageable);
}
