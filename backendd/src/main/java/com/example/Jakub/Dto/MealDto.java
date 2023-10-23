package com.example.Jakub.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealDto {
    private String mealName;
    private float calories;
    private float proteins;
    private float carbohydrates;
    private float fats;
    private String recipe;
    private boolean hasMeat;
    private boolean hasGluten;
    private String categoryName;
}
