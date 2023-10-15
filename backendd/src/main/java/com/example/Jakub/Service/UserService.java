package com.example.Jakub.Service;

import com.example.Jakub.Dto.UserProfileDto;
import com.example.Jakub.Entity.UserProfile;
import com.example.Jakub.Exception.AppException;
import com.example.Jakub.Config.SecurityConfig;
import com.example.Jakub.Dto.SignUpDto;
import com.example.Jakub.Dto.UserDto;
import com.example.Jakub.Entity.UserInfo;
import com.example.Jakub.Mapper.UserMapper;
import com.example.Jakub.Mapper.UserProfileMapper;
import com.example.Jakub.Repository.UserInfoRepository;
import com.example.Jakub.Repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserInfoRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Autowired
    private JwtService jwtService;

    public UserDto findByUsername(String username) {
        UserInfo user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ExpressionException("No such user"));
        return userMapper.toUserDto(user);
    }

    public UserDto login(SignUpDto signUpDto) {
        System.out.println(signUpDto.getUsername());
        System.out.println(signUpDto.getPassword());
        UserInfo user = userRepository.findByUsername(signUpDto.getUsername())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (securityConfig.passwordEncoder().matches((signUpDto.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto signUpDto) {
        System.out.println(signUpDto.getUsername());
        System.out.println(signUpDto.getPassword());
        Optional<UserInfo> optionalUser = userRepository.findByUsername(signUpDto.getUsername());

        if (optionalUser.isPresent()) {
            throw new AppException("This username already exists", HttpStatus.BAD_REQUEST);
        }

        UserInfo user = userMapper.signUpToUser(signUpDto);
        user.setPassword(securityConfig.passwordEncoder().encode(signUpDto.getPassword()));

        UserInfo savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserProfileDto newUserProfile(String bearerToken, UserProfileDto userProfileDto){
        UserInfo loggedUser = userRepository.findUserInfoByUsername(jwtService.extractUsername(bearerToken));

        if (loggedUser.getUserProf() != null) {
            throw new AppException("This username already got user Profile set!", HttpStatus.BAD_REQUEST);
        }

        UserProfile user = userProfileMapper.signUpToUserProfile(userProfileDto);
        UserProfile savedUser = userProfileRepository.save(user);

        loggedUser.setUserProf(savedUser);
        userRepository.save(loggedUser);

        return userProfileMapper.toUserProfileDto(savedUser);
}

    public UserProfileDto getUserProfile(String bearerToken){
        UserInfo loggedUser = userRepository.findUserInfoByUsername(jwtService.extractUsername(bearerToken));

        if (loggedUser.getUserProf() == null) {
            throw new AppException("This username got no user Profile set!", HttpStatus.BAD_REQUEST);
        }

        UserProfile DBuser = userProfileRepository.findByProfileId(loggedUser.getUserProf().getProfileId());

        return userProfileMapper.toUserProfileDto(DBuser);
    }

//    public String newUserProfile(@RequestHeader("Authorization") String bearerToken){
//        UserProfile user = jwtService.extractUsername(bearerToken);
//    }

    public List<UserInfo> getListOfAllUsers(){
        List<UserInfo> listOfAllUsers = userRepository.findAll();
        return listOfAllUsers;
    }


}