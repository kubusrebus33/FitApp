package com.example.Jakub.Controller;

import com.example.Jakub.Dto.MealDto;
import com.example.Jakub.Dto.MealIdDto;
import com.example.Jakub.Entity.Meal;
import com.example.Jakub.Entity.MealIngredient;
import com.example.Jakub.Mapper.MealMapper;
import com.example.Jakub.Service.JwtService;
import com.example.Jakub.Service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/deleteDiet")
    public void seed1(@RequestHeader HttpHeaders headers) {
        String bearerToken = headers.getFirst(HttpHeaders.AUTHORIZATION);
        bearerToken = bearerToken.substring(7);
        mealService.deleteDiet(bearerToken);
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

    @GetMapping("/changeMeal")
    public ResponseEntity<List<MealDto>> changeMeals(@RequestHeader HttpHeaders headers, @RequestBody MealIdDto mealIdDto) {
        String bearerToken = headers.getFirst(HttpHeaders.AUTHORIZATION);
        bearerToken = bearerToken.substring(7);

        List<MealDto> listOfMeals = new ArrayList<>();

        List<Meal> newList = mealService.changeMeal(bearerToken, mealIdDto.getMealsId());

        for(Meal meal : newList){
            List<String> ingredientAssoc = new ArrayList<>();
            for (MealIngredient element : meal.getIngredientAssoc()) {
                ingredientAssoc.add(element.toString());
            }
            MealDto m = mealMapper.toMealDto(meal);
            m.setIngredientAssoc(ingredientAssoc);
            listOfMeals.add(m);
        }
        return ResponseEntity.ok(listOfMeals);
    }

    @GetMapping("/postUserDiet")
    public ResponseEntity<List<MealDto>> postDiet(@RequestHeader HttpHeaders headers) {
        String bearerToken = headers.getFirst(HttpHeaders.AUTHORIZATION);
        bearerToken = bearerToken.substring(7);

        List<MealDto> listOfMeals = new ArrayList<>();
        List<Meal> newList = mealService.postDiet(bearerToken);

        for(Meal meal : newList){
            List<String> ingredientAssoc = new ArrayList<>();
                for (MealIngredient element : meal.getIngredientAssoc()) {
                    ingredientAssoc.add(element.toString());
                }
            MealDto m = mealMapper.toMealDto(meal);
            m.setIngredientAssoc(ingredientAssoc);
            listOfMeals.add(m);
        }
        return ResponseEntity.ok(listOfMeals);
    }

    @GetMapping("/getUserDiet")
    public ResponseEntity<List<MealDto>> getDiet(@RequestHeader HttpHeaders headers) {
        String bearerToken = headers.getFirst(HttpHeaders.AUTHORIZATION);
        bearerToken = bearerToken.substring(7);

        List<MealDto> listOfMeals = new ArrayList<>();
        System.out.println(" XXXXXXXXXXXXXXXXXX ");
        List<Meal> newList = mealService.getDiet(bearerToken);
        System.out.println(" CCCCCCCCCCCCCCCCCC ");
        for(Meal meal : newList){
            List<String> ingredientAssoc = new ArrayList<>();
            for (MealIngredient element : meal.getIngredientAssoc()) {
                ingredientAssoc.add(element.toString());
            }
            MealDto m = mealMapper.toMealDto(meal);
            m.setIngredientAssoc(ingredientAssoc);
            listOfMeals.add(m);
        }
        return ResponseEntity.ok(listOfMeals);
    }

}
