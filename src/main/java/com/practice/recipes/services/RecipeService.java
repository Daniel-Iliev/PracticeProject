package com.practice.recipes.services;

import com.practice.recipes.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface RecipeService extends CrudRepository<Recipe,Integer> {

}
