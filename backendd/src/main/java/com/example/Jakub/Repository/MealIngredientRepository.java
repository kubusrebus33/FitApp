package com.example.Jakub.Repository;


import com.example.Jakub.Entity.MealIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealIngredientRepository extends JpaRepository<MealIngredient, Integer> {
}
