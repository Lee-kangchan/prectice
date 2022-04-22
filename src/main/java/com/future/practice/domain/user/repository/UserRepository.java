package com.future.practice.domain.user.repository;

import com.future.practice.global.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByUserEmailAndUserPassword(String userEmail, String userPassword );
    Optional<User> findUserByUserEmail(String userEmail);
    Optional<User> findUserByUserPhone(String userPhone);
    void deleteUserByUserEmail(String userEmail);
}
