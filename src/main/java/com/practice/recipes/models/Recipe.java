package com.practice.recipes.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="recipes")
public class Recipe{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("recipe-name")
    private String name;
    @Embedded
    @JsonProperty("recipe-ingredients")
    private List<Ingredient> ingredients;

    @JsonProperty("recipe-author-id")
    private String authorId;

    @JsonProperty("recipe-minutes-needed")
    private int minutesNeeded;

    @JsonProperty("recipe-description")
    private String description;
    private Date dateCreated;
    public Recipe() {
    }

    public Recipe(String name, Integer id, List<Ingredient> ingredients, String authorId, int minutesNeeded, String description) {
        this.name = name;
        this.id = id;
        this.ingredients = ingredients;
        this.authorId = authorId;
        this.minutesNeeded = minutesNeeded;
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

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
