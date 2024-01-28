package com.example.Jakub.Mapper;

import com.example.Jakub.Dto.MealKitDto;
import com.example.Jakub.Entity.mealKit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MealKitMapper {

    @Mapping(source = "_meal.mealName", target = "mealName")
    @Mapping(source = "_meal.calories", target = "calories")
    @Mapping(source = "_meal.proteins", target = "proteins")
    @Mapping(source = "_meal.carbohydrates", target = "carbohydrates")
    @Mapping(source = "_meal.fats", target = "fats")
    @Mapping(source = "_meal.recipe", target = "recipe")
    @Mapping(source = "_meal.hasMeat", target = "hasMeat")
    @Mapping(source = "_meal.hasGluten", target = "hasGluten")
    @Mapping(source = "_meal.hasLactose", target = "hasLactose")
    @Mapping(source = "_meal.categoryName", target = "categoryName")
    @Mapping(source = "_meal.ingredientAssoc", target = "ingredientAssoc", ignore=true)
    MealKitDto toMealKitDto(mealKit mealKit);
}