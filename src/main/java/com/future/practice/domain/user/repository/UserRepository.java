package com.future.practice.domain.user.repository;

import com.future.practice.global.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByUserEmail(User user);
    Optional<User> findUserByUserPhone(User user);
    void deleteUserByUserEmailAndUserPassword(User user);
}
