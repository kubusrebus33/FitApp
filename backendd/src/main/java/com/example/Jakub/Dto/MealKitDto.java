package com.example.Jakub.Dto;

import com.example.Jakub.Entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealKitDto {
    private int mealGroup;
    private String mealName;
    private int calories;
    private float proteins;
    private float carbohydrates;
    private float fats;
    private String recipe;
    private int hasMeat;
    private int hasGluten;
    private int hasLactose;
    private String categoryName;
    private List<String> ingredientAssoc;
}
