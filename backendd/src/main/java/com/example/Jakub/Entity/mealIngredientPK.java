package com.example.Jakub.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class mealIngredientPK implements Serializable {
    private int meal;
    private int ingredient;
}
