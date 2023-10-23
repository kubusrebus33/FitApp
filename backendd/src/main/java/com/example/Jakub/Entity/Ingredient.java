package com.example.Jakub.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Getter
@Setter
@Table(name="ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Long ingredientId;

    @Column(name = "meal_name", nullable = false, length = 50)
    private String ingredientName;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="meal_id", nullable=false)
    private Meal mealNumber;
}
