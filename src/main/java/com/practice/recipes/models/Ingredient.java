package com.practice.recipes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;

@Embeddable
public class Ingredient {

    @JsonProperty("ingredient-name")
    private String name;
    @JsonProperty("ingredient-quantity")
    private int quantity;

    public Ingredient() {
    }

    public Ingredient(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
