package com.gjorgiev.gethired.controllers;

import com.gjorgiev.gethired.dto.request.SearchRequest;
import com.gjorgiev.gethired.dto.response.RecentSearchResponse;
import com.gjorgiev.gethired.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}/recent-searches")
    public ResponseEntity<List<RecentSearchResponse>> getAllRecentSearches(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getAllRecentSearches(userId));
    }

}
