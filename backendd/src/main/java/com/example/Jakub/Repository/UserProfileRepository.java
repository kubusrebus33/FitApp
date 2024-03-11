package com.example.Jakub.Repository;

import com.example.Jakub.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    UserProfile findByProfileId(Integer id);

    @Override
    void deleteById(Integer integer);
}