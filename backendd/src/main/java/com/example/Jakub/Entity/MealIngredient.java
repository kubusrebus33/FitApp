package com.example.Jakub.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "meal_ingredient")
@IdClass(MealIngredient.class)
public class MealIngredient {
    @Id
    @ManyToOne
    @JoinColumn(name = "meal_id", referencedColumnName = "meal_id")
    private Meal meal;

    @Id
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id")
    private Ingredient ingredient;

    @Column(name = "quantity")
    private int quantity;

    @Override
    public String toString() {
//        return "{" +
//                "\"name\":\"" + ingredient + "\"," +
//                "\"quantity\":" + quantity +
//                "}";
        return ingredient+ ":" +quantity+"g";
    }
}
