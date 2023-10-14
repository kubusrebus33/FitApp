package com.example.Jakub.Controller;

import com.example.Jakub.Dto.AuthRequest;
import com.example.Jakub.Dto.SignUpDto;
import com.example.Jakub.Dto.UserDto;
import com.example.Jakub.Entity.UserInfo;
import com.example.Jakub.Service.JwtService;
import com.example.Jakub.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody AuthRequest authRequest) {
        UserDto userDto_ = userService.login(authRequest);
        userDto_.setToken(jwtService.generateToken(userDto_.getUsername()));
        return ResponseEntity.ok(userDto_);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto user) {
        UserDto createdUser = userService.register(user);
        createdUser.setToken(jwtService.generateToken(user.getUsername()));
        return ResponseEntity.ok(createdUser);
//        return ResponseEntity.created(URI.create("/users/" + createdUser.getUserId())).body(createdUser);
    }

    @GetMapping("/getAll")
    public List<UserInfo> getAll(){
        return userService.getListOfAllUsers();
    }
}