package com.example.Jakub.Repository;


import com.example.Jakub.Entity.UserInfo;
import com.example.Jakub.Entity.mealKit;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface mealKitRepository extends JpaRepository<mealKit, Integer> {

    boolean existsBy_user(UserInfo user);

    List<mealKit> findAllBy_userAndMealGroup(UserInfo user, int mealGroup);

    List<mealKit> findAllBy_user(UserInfo user);

    @Transactional
    void deleteBy_user(UserInfo user);

    @Transactional
    void deleteAllBy_userAndMealGroup(UserInfo user, int mealGroup);
}
