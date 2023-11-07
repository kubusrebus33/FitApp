package com.example.Jakub.Repository;

import com.example.Jakub.Entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Integer> {
    Meal findMealByMealId(int id);
    Meal findMealByMealName(String name);
    List<Meal> findFirst10ByHasMeat(int x);
    List<Meal> findFirst10ByHasGluten(int x);
    List<Meal> findFirst10ByHasLactose(int x);
    @Query(value = "SELECT * FROM Meal WHERE has_Meat = :hasMeat AND has_Gluten = :hasGluten AND has_Lactose = :hasLactose ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Meal findRandomByDietInfo(@Param("hasMeat") int x, @Param("hasGluten") int y, @Param("hasLactose") int z);
}
