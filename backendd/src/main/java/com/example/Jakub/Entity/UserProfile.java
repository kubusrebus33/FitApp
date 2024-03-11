package com.example.Jakub.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Getter
@Setter
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private int profileId;

    @Column(name = "height")
    private int height;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private char sex;

    @Column(name = "weight")
    private float weight;

    @Column(name = "activity_level")
    private int activityLevel;

    @Column(name = "goal")
    private int goal;

    @Column(name = "bmi")
    private float bmi;

    @Column(name = "caloric_demand")
    private int caloricDemand;

    @Column(name = "dietInfo")
    private int dietInfo;

    @OneToOne(mappedBy = "userProf")
    private UserInfo userInfo;
}
