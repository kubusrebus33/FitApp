package com.example.Jakub.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "mealKit")
@IdClass(mealKit.class)
public class mealKit {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserInfo _user;

    @Id
    @ManyToOne
    @JoinColumn(name = "meal_id", referencedColumnName = "meal_id")
    private Meal _meal;
}
