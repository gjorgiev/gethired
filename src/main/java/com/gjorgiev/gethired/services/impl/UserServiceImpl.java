package com.gjorgiev.gethired.services.impl;

import com.gjorgiev.gethired.dto.request.SearchRequest;
import com.gjorgiev.gethired.dto.response.RecentSearchResponse;
import com.gjorgiev.gethired.exceptions.ApiRequestException;
import com.gjorgiev.gethired.models.User;
import com.gjorgiev.gethired.repositories.UserRepository;
import com.gjorgiev.gethired.services.RecentSearchService;
import com.gjorgiev.gethired.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RecentSearchService recentSearchService;
    private final ModelMapper modelMapper;
    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
    @Override
    public User getUserById(Long userId) {
        return userRepository.findUserById(userId)
                .orElseThrow(() -> new ApiRequestException("User with id = " + userId + " not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<RecentSearchResponse> getAllRecentSearches(Long userId) {
        return recentSearchService.getAllByUserId(userId);
    }

    @Override
    public RecentSearchResponse createRecentSearch(SearchRequest searchRequest) {
        return recentSearchService.createRecentSearch(searchRequest);
    }
}
