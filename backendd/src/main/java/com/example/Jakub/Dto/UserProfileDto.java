package com.example.Jakub.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileDto {

    private int height;
    private float weight;
    private int age;
    private int caloricDemand;
    private char sex;
    private float bmi;
    private int activityLevel;
    private int goal;
}