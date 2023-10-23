package com.example.Jakub.Service;

import com.example.Jakub.Entity.Ingredient;
import com.example.Jakub.Entity.Meal;
import com.example.Jakub.Repository.IngredientRepository;
import com.example.Jakub.Repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@RequiredArgsConstructor
@Service
public class MealService {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public void addMeal(){

        Meal newMeal = new Meal("Kurczak teriyaki z ryżem i brokułem", 814, 58.6f, 93, 26.1f, "Ryż ugotuj. Brokuł podziel na mniejsze różyczki, marchewkę pokrój w drobną kostkę...\n", 1, 0, "Dinner", new HashSet<Ingredient>() {
        });
        Meal newMeal1 = new Meal("Kawowy shake proteinowy", 717, 44.7f, 97.1f, 19.4f, "Kawę zaparz i ostudź.\n" +
                "Wszystkie składniki zblenduj na koktajl.", 0, 0 , "Snack",new HashSet<Ingredient>() {
        });
        final Meal finalMeal = mealRepository.save(newMeal);
        final Meal finalMeal1 = mealRepository.save(newMeal1);

        Set<Ingredient> ingSet = new HashSet<Ingredient>(){{
            add(new Ingredient("Brown Rice", 100, newMeal));
            add(new Ingredient("Broccoli", 150, newMeal));
            add(new Ingredient("Carrot", 45, newMeal));
        }};

        Set<Ingredient> ingSet1 = new HashSet<Ingredient>(){{
            add(new Ingredient("Kawa", 50, newMeal1));
            add(new Ingredient("Mleko", 300, newMeal1));
            add(new Ingredient("Banan", 240, newMeal1));
        }};

        for (Ingredient ingredient : ingSet) {
            ingredientRepository.save(ingredient);
        }

        for (Ingredient ingredient : ingSet1) {
            ingredientRepository.save(ingredient);
        }
    }

    public void getMeal(){
        Meal x = mealRepository.findMealByMealId(1);

//        HashSet<Ingredient> newHash = new HashSet<>(ingredientRepository.findIngredientByMealNumber(x));
//        x.setIngredientSet(ingredientRepository.findIngredientByMealNumber(x));
        HashSet<Ingredient> newHash = new HashSet();
        x.setIngredientSet(newHash);
        System.out.println(ingredientRepository.findIngredientByMealNumber(x));
//        x.setIngredientSet(newHash);

        System.out.println(x);
    }
}
