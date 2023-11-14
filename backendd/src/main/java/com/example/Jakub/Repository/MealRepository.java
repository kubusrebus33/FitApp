package com.example.Jakub.Repository;

import com.example.Jakub.Entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Integer> {
    Meal findMealByMealId(int id);
    Meal findMealByMealName(String name);
    @Query(value = "SELECT * FROM Meal WHERE has_Lactose = :hasLactose ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Meal findRandomLactoseFreeByDietInfo(@Param("hasLactose") int z);
    @Query(value = "SELECT * FROM Meal WHERE has_Lactose = :hasGluten ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Meal findRandomGlutenFreeByDietInfo(@Param("hasGluten") int z);
    @Query(value = "SELECT * FROM Meal WHERE has_Lactose = :hasMeat ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Meal findRandomMeatFreeByDietInfo(@Param("hasMeat") int z);
    @Query(value = "SELECT * FROM Meal ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Meal findRandom();
}
