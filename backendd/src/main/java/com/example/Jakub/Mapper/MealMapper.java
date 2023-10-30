package com.example.Jakub.Mapper;

import com.example.Jakub.Dto.MealDto;
import com.example.Jakub.Entity.Meal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MealMapper {

    @Mapping(target = "ingredientAssoc", ignore = true)
    MealDto toMealDto(Meal meal);

    @Mapping(target = "ingredientAssoc", ignore = true)
    Meal toMeal(MealDto mealDto);
}