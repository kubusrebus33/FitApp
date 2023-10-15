package com.example.Jakub.Controller;

import com.example.Jakub.Dto.SignUpDto;
import com.example.Jakub.Dto.UserDto;
import com.example.Jakub.Dto.UserProfileDto;
import com.example.Jakub.Entity.UserInfo;
import com.example.Jakub.Service.JwtService;
import com.example.Jakub.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid SignUpDto signUpDto) {
        UserDto user = userService.login(signUpDto);
        user.setToken(jwtService.generateToken(user.getUsername()));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto signUpDto) {
        UserDto user = userService.register(signUpDto);
        user.setToken(jwtService.generateToken(user.getUsername()));
        return ResponseEntity.ok(user);
//        return ResponseEntity.created(URI.create("/users/" + createdUser.getUserId())).body(createdUser);
    }

    @PostMapping("/addUserProfile")
    public ResponseEntity<UserProfileDto> addProfile(@RequestHeader HttpHeaders headers, @RequestBody UserProfileDto userProfileDto) {
        String bearerToken = headers.getFirst(HttpHeaders.AUTHORIZATION);
        bearerToken = bearerToken.substring(7);

        UserProfileDto userProfile = userService.newUserProfile(bearerToken, userProfileDto);
        return ResponseEntity.ok(userProfile);
//        return ResponseEntity.created(URI.create("/users/" + createdUser.getUserId())).body(createdUser);
    }

    @GetMapping("/getUserProfile")
    public ResponseEntity<UserProfileDto> getProfile(@RequestHeader HttpHeaders headers) {
        String bearerToken = headers.getFirst(HttpHeaders.AUTHORIZATION);
        bearerToken = bearerToken.substring(7);

        UserProfileDto userProfile = userService.getUserProfile(bearerToken);
        return ResponseEntity.ok(userProfile);
//        return ResponseEntity.created(URI.create("/users/" + createdUser.getUserId())).body(createdUser);
    }

    @GetMapping("/getAll")
    public List<UserInfo> getAll(){
        return userService.getListOfAllUsers();
    }
}