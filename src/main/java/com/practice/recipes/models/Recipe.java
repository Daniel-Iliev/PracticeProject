package com.practice.recipes.models;


import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table(name="recipes")
public class Recipe{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    private ArrayList<Ingredient> ingredients;
    private String authorId;
    private int minutesNeeded;
    private String description;
    public Recipe() {
    }

    public Recipe(String name, Integer id, ArrayList<Ingredient> ingredients, String authorId, int minutesNeeded, String description) {
        this.name = name;
        this.id = id;
//        this.ingredients = ingredients;
        this.authorId = authorId;
        this.minutesNeeded = minutesNeeded;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public ArrayList<Ingredient> getIngredients() {
//        return ingredients;
//    }

//    public void setIngredients(ArrayList<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public int getMinutesNeeded() {
        return minutesNeeded;
    }

    public void setMinutesNeeded(int minutesNeeded) {
        this.minutesNeeded = minutesNeeded;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
