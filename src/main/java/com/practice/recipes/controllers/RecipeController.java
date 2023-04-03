package com.practice.recipes.controllers;

import com.practice.recipes.FieldErrorMessage;
import com.practice.recipes.models.Recipe;
import com.practice.recipes.services.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class RecipeController {
    @Autowired
    RecipeService recipeService;
    @PostMapping("/recipe")
    Recipe create(@Valid @RequestBody Recipe recipe){
        recipe.setDateCreated(new Date());
        return recipeService.save(recipe);
    }
    @GetMapping("/recipe")
    Iterable<Recipe> read(){
        return recipeService.findAll();
    }
    @PutMapping("/recipe")
    Recipe update(@Valid @RequestBody Recipe recipe){
        return recipeService.save(recipe);
    }
    @DeleteMapping("/recipe/{id}")
    void delete(@PathVariable Integer id){
        recipeService.deleteById(id);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(),fieldError.getDefaultMessage())).collect(Collectors.toList());
        return fieldErrorMessages;
    }
}
