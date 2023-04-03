package com.practice.recipes.services;

import com.practice.recipes.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RecipeService extends JpaRepository<Recipe,Integer> {

}
