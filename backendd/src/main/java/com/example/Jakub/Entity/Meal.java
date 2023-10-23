package com.example.Jakub.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Getter
@Setter
@Table(name="meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Long mealId;

    @Column(name = "meal_name", nullable = false, length = 50)
    private String mealName;

    @Column(name = "calories")
    private float calories;

    @Column(name = "proteins")
    private float proteins;

    @Column(name = "carbohydrates")
    private float carbohydrates;

    @Column(name = "fats")
    private float fats;

    @Column(name="recipe")
    private String recipe;

    @Column(name = "has_meat")
    private boolean hasMeat;

    @Column(name = "has_gluten")
    private boolean hasGluten;

    @Column(name = "category_name", length = 15)
    private String categoryName;

    @OneToMany(mappedBy="mealNumber")
    private Set<Ingredient> ingredientSet;
}
