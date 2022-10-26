package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
