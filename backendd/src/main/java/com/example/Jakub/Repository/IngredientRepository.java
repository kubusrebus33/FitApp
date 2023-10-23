package com.example.Jakub.Repository;
import com.example.Jakub.Entity.Ingredient;
import com.example.Jakub.Entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    HashSet<Ingredient> findIngredientByMealNumber(Meal meal);
//    @Query("SELECT i.ingredientId, i.ingredientName, i.quantity FROM Ingredient i WHERE i.mealNumber = :meal")
//    List<Object[]> findIngredientsInfoByMealNumber(@Param("meal") Meal meal);
}
