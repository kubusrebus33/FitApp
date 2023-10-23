package com.example.Jakub.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@NoArgsConstructor
@Data
@Table(name="ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private int ingredientId;

    @Column(name = "meal_name", nullable = false, length = 50)
    private String ingredientName;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="meal_id")
    private Meal mealNumber;

    public Ingredient(String ingredientName, int quantity, Meal mealNumber) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.mealNumber = mealNumber;
    }
    public Ingredient(String ingredientName, int quantity) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
    }
}
