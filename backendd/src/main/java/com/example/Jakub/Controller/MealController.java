package com.example.Jakub.Controller;

import com.example.Jakub.Service.JwtService;
import com.example.Jakub.Service.MealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class    MealController {

    @Autowired
    private MealService mealService;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/addMeal")
    public int login() {
        mealService.addMeal();
        return 1;
    }

    @GetMapping("/getMeal")
    public int lol() {
        mealService.getMeal();
        return 1;
    }

}
