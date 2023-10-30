package com.example.Jakub.Repository;
import com.example.Jakub.Entity.Ingredient;
import com.example.Jakub.Entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    Ingredient findIngredientByIngredientId(int id);
    Ingredient findIngredientByIngredientName(String name);
}
