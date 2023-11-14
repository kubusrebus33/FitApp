package com.example.Jakub.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private int mealId;

    @Column(name = "meal_name", nullable = false, length = 100)
    private String mealName;

    @Column(name = "calories", nullable = false)
    private float calories;

    @Column(name = "proteins", nullable = false)
    private float proteins;

    @Column(name = "carbohydrates", nullable = false)
    private float carbohydrates;

    @Column(name = "fats", nullable = false)
    private float fats;

    @Column(name="recipe", length = 1000, nullable = false)
    private String recipe;

    @Column(name = "has_meat", nullable = false)
    private int hasMeat;

    @Column(name = "has_gluten", nullable = false)
    private int hasGluten;

    @Column(name = "has_lactose", nullable = false)
    private int hasLactose;

    @Column(name = "category_name", length = 15, nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "meal")
    private List<MealIngredient> ingredientAssoc;

    @OneToMany(mappedBy = "_meal")
    private List<mealKit> x;

    public Meal(String mealName, float calories, float proteins, float carbohydrates, float fats, String recipe, int hasMeat, int hasGluten, int hasLactose, String categoryName) {
        this.mealName = mealName;
        this.calories = calories;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.recipe = recipe;
        this.hasMeat = hasMeat;
        this.hasGluten = hasGluten;
        this.hasLactose = hasLactose;
        this.categoryName = categoryName;
    }
}
