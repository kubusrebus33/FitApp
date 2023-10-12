package com.example.Jakub.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
    private int userId;

//    @NonNull
//    @Column(name = "username")
    private String username;

//    @NonNull
//    @Column(name = "password")
    private String password;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="user_profile_id", referencedColumnName = "profile_id")
//    private UserProfile userProfile;
}
