package com.practice.recipes.controllers;

import com.practice.recipes.ErrorMessage;
import com.practice.recipes.FieldErrorMessage;
import com.practice.recipes.models.User;
import com.practice.recipes.services.UserService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/user")
    Iterable<User> read(){
        return userService.findAll();
    }
    @GetMapping("/user/search")
    Optional<User> findByUsername(@RequestParam String username){
        return userService.findByUsername(username);
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
