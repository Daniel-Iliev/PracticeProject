package com.practice.recipes.services;

import com.practice.recipes.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends CrudRepository<User,Integer> {
    User findByUsername(String username);
}
