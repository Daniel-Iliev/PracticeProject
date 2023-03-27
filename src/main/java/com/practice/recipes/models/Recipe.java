package com.practice.recipes.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="recipes")
public class Recipe{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @JsonProperty("recipe-name")
    private String name;
    @Embedded
    @ElementCollection
    @JsonProperty("recipe-ingredients")
    private Collection<Ingredient> ingredients;
    @NotNull
    @JsonProperty("recipe-author-id")
    private int authorId;
    @Min(1)
    @JsonProperty("recipe-minutes-needed")
    private int minutesNeeded;

    @NotBlank
    @JsonProperty("recipe-description")
    private String description;
    private Date dateCreated;
    public Recipe() {
    }

    public Recipe(String name, Integer id, Collection<Ingredient> ingredients, int authorId, int minutesNeeded, String description) {
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

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
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
