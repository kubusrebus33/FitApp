package com.example.Jakub.Repository;
import com.example.Jakub.Entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    Ingredient findIngredientByIngredientId(int id);
    Ingredient findIngredientByIngredientName(String name);
}
