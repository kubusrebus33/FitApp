package com.example.Jakub.Dto;

import com.example.Jakub.Entity.UserInfo;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
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
    private int age;
    private char sex;
    private float weight;
    private int activityLevel;
    private int workActivityLevel;
    private int goal;
    private float caloricDemand;
    private float bmi;
}