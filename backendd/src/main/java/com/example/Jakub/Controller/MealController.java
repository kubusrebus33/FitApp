package com.example.Jakub.Controller;

import com.example.Jakub.Dto.MealDto;
import com.example.Jakub.Dto.MealIdDto;
import com.example.Jakub.Dto.MealKitDto;
import com.example.Jakub.Dto.MealNameDto;
import com.example.Jakub.Entity.Meal;
import com.example.Jakub.Entity.MealIngredient;
import com.example.Jakub.Entity.mealKit;
import com.example.Jakub.Mapper.MealKitMapper;
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
    private MealKitMapper mealKitMapper;

    @Autowired
    private MealMapper mealMapper;

    @GetMapping("/seedMeals")
    public void seed() {
        mealService.seedMeals();
    }

    @GetMapping("/deleteDiet")
    public void deleteOneDiet(@RequestHeader HttpHeaders headers) {
        String bearerToken = headers.getFirst(HttpHeaders.AUTHORIZATION);
        bearerToken = bearerToken.substring(7);
        mealService.deleteDiet(bearerToken);
    }

    @DeleteMapping("/deleteSevenDiet")
    public void deleteSevenDiet(@RequestHeader HttpHeaders headers) {
        String bearerToken = headers.getFirst(HttpHeaders.AUTHORIZATION);
        bearerToken = bearerToken.substring(7);
        mealService.deleteSevenDiet(bearerToken);
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

    @PostMapping("/changeMeal")
    public ResponseEntity<List<MealDto>> changeMeals(@RequestHeader HttpHeaders headers, @RequestBody MealNameDto mealNames) {
        String bearerToken = headers.getFirst(HttpHeaders.AUTHORIZATION);
        bearerToken = bearerToken.substring(7);

        System.out.println(mealNames);

        List<MealDto> listOfMeals = new ArrayList<>();

        List<Meal> newList = mealService.changeMeal(bearerToken, mealNames.getMealNames());

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

    @GetMapping("/postOneDayDiet")
    public ResponseEntity<List<MealDto>> post1DayDiet(@RequestHeader HttpHeaders headers) {
        String bearerToken = headers.getFirst(HttpHeaders.AUTHORIZATION);
        bearerToken = bearerToken.substring(7);

        List<MealDto> listOfMeals = new ArrayList<>();
        List<Meal> newList = mealService.postOneDayDiet(bearerToken);

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

    @GetMapping("/postSevenDayDiet")
    public ResponseEntity<List<MealDto>> post7DayDiet(@RequestHeader HttpHeaders headers) {
        String bearerToken = headers.getFirst(HttpHeaders.AUTHORIZATION);
        bearerToken = bearerToken.substring(7);

        List<MealDto> listOfMeals = new ArrayList<>();
        List<Meal> newList = mealService.postSevenDayDiet(bearerToken);

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

    @GetMapping("/GetMealKitInfo")
    public ResponseEntity<List<MealKitDto>> getInfo(@RequestHeader HttpHeaders headers) {
        String bearerToken = headers.getFirst(HttpHeaders.AUTHORIZATION);
        bearerToken = bearerToken.substring(7);

        List<mealKit> newList = mealService.getMealKits(bearerToken);
        List<MealKitDto> newListX = new ArrayList<>();
        for(mealKit x : newList){
            List<String> ingredientAssoc = new ArrayList<>();
            for (MealIngredient element : x.get_meal().getIngredientAssoc()) {
                ingredientAssoc.add(element.toString());
            }
            MealKitDto m = mealKitMapper.toMealKitDto(x);
            m.setIngredientAssoc(ingredientAssoc);
            newListX.add(m);
        }

        System.out.println(newListX);
        return ResponseEntity.ok(newListX);
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
