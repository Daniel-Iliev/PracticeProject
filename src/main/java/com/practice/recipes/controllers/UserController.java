package com.practice.recipes.controllers;

import com.practice.recipes.ErrorMessage;
import com.practice.recipes.FieldErrorMessage;
import com.practice.recipes.models.User;
import com.practice.recipes.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/user")
    User create(@Valid @RequestBody User user){
            if (!userService.findByUsername(user.getUsername()).isPresent()){
                return userService.save(user);
            }
            else{
                throw new ValidationException("Username already exists");
            }
    }

    @GetMapping("/user")
    Iterable<User> read(){
        return userService.findAll();
    }
    @GetMapping("/user/search")
    Optional<User> findByQuery(@RequestParam String username){
        return userService.findByUsername(username);
    }
    @PutMapping("/user")
    ResponseEntity<User> update(@Valid @RequestBody User user){
        if (userService.findById(user.getId()).isPresent()){
            return new ResponseEntity(userService.save(user), HttpStatus.OK);
        }
        else{
            return new ResponseEntity(user, HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/user/{id}")
    void delete(@PathVariable Integer id){
        userService.deleteById(id);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    ErrorMessage exceptionHandler(ValidationException e){
        return new ErrorMessage("400",e.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(),fieldError.getDefaultMessage())).collect(Collectors.toList());
        return fieldErrorMessages;
    }
}
