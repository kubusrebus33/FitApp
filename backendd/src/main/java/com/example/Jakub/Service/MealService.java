package com.example.Jakub.Service;

import com.example.Jakub.Config.SecurityConfig;
import com.example.Jakub.Dto.MealDto;
import com.example.Jakub.Dto.UserProfileDto;
import com.example.Jakub.Entity.UserInfo;
import com.example.Jakub.Entity.UserProfile;
import com.example.Jakub.Exception.AppException;
import com.example.Jakub.Mapper.UserMapper;
import com.example.Jakub.Mapper.UserProfileMapper;
import com.example.Jakub.Repository.UserInfoRepository;
import com.example.Jakub.Repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MealService {
    @Autowired
    private JwtService jwtService;

    public void addMeal(MealDto mealDto){
//        UserInfo loggedUser = userRepository.findUserInfoByUsername(jwtService.extractUsername(bearerToken));
//
//        if (loggedUser.getUserProf() != null) {
//            throw new AppException("This username already got user Profile set!", HttpStatus.BAD_REQUEST);
//        }
//
//        UserProfile user = userProfileMapper.signUpToUserProfile(userProfileDto);
//        System.out.println(user);
//        UserProfile savedUser = userProfileRepository.save(user);
//        System.out.println(savedUser);
//
//        loggedUser.setUserProf(savedUser);
//        userRepository.save(loggedUser);
//
//        return userProfileMapper.toUserProfileDto(savedUser);
    }

}
