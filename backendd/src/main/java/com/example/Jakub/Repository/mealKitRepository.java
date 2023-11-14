package com.example.Jakub.Repository;


import com.example.Jakub.Entity.UserInfo;
import com.example.Jakub.Entity.mealKit;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface mealKitRepository extends JpaRepository<mealKit, Integer> {
    boolean existsBy_user(UserInfo user);

    @Transactional
    void deleteBy_user(UserInfo user);

    @Transactional
    void deleteAllBy_user(UserInfo user);
}
