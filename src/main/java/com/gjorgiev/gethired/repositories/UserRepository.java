package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Skill;
import com.gjorgiev.gethired.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT user FROM User user WHERE user.location.id = :locationId")
    List<User> findAllByLocationId(Long locationId);
    List<User> findAllBySkills(Skill skill);
    @Query("SELECT user FROM User user WHERE user.id = :userId")
    Optional<User> findUserById(Long userId);
}
