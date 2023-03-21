package com.practice.recipes.controllers;

import com.practice.recipes.models.Recipe;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    public Recipe getRecipe(String recipeId){
        Recipe recipe = new Recipe();
        return recipe;
    }
}
