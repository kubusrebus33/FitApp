package com.example.Jakub.Repository;

import com.example.Jakub.Entity.Meal;
import com.example.Jakub.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer> {
    Meal findMealByMealId(int id);
}
