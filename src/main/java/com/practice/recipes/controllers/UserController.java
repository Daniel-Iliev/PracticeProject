package com.practice.recipes.controllers;

import com.practice.recipes.models.User;
import com.practice.recipes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/user")
    User create(@RequestBody User user){
        return userService.save(user);
    }
    @GetMapping("/user")
    Iterable<User> read(){
        return userService.findAll();
    }
    @GetMapping("/user/search")
    User findByQuery(@RequestParam String username){
        return userService.findByUsername(username);
    }
    @PutMapping("/user")
    User update(@RequestBody User user){
        return userService.save(user);
    }
    @DeleteMapping("/user/{id}")
    void delete(@PathVariable Integer id){
        userService.deleteById(id);
    }
}
