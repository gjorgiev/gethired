package com.gjorgiev.gethired.services;

import com.gjorgiev.gethired.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> getUsers(Pageable pageable);
}
