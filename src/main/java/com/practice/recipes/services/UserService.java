package com.practice.recipes.services;

import com.practice.recipes.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
