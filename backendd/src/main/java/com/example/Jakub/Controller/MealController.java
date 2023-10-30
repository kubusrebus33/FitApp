package com.example.Jakub.Controller;

import com.example.Jakub.Dto.MealDto;
import com.example.Jakub.Entity.Meal;
import com.example.Jakub.Entity.MealIngredient;
import com.example.Jakub.Mapper.MealMapper;
import com.example.Jakub.Service.JwtService;
import com.example.Jakub.Service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MealController {

    @Autowired
    private MealService mealService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MealMapper mealMapper;

    @GetMapping("/seedMeals")
    public void seed() {
        mealService.seedMeals();
    }

    @GetMapping("/getMeal/{id}")
    public ResponseEntity<MealDto> lol(@PathVariable int id) {
        Meal x = mealService.getMeal(id);
        MealDto y = mealMapper.toMealDto(x);

            List<String> ingredientAssoc = new ArrayList<>();

        for (MealIngredient element : x.getIngredientAssoc()) {
            ingredientAssoc.add(element.toString());
        }
            y.setIngredientAssoc(ingredientAssoc);

        return ResponseEntity.ok(y);
    }
}
