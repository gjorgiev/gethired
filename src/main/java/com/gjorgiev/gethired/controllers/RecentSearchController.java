package com.gjorgiev.gethired.controllers;

import com.gjorgiev.gethired.dto.request.SearchRequest;
import com.gjorgiev.gethired.dto.response.RecentSearchResponse;
import com.gjorgiev.gethired.services.RecentSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
public class RecentSearchController {
    private final RecentSearchService recentSearchService;

    @GetMapping("/{searchId}")
    public ResponseEntity<RecentSearchResponse> getSearchById(@PathVariable Long searchId){
        return ResponseEntity.ok(recentSearchService.getSearchById(searchId));
    }

}
