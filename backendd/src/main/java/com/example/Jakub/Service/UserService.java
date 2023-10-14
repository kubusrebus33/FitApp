package com.example.Jakub.Service;

import com.example.Jakub.Exception.AppException;
import com.example.Jakub.Config.SecurityConfig;
import com.example.Jakub.Dto.AuthRequest;
import com.example.Jakub.Dto.SignUpDto;
import com.example.Jakub.Dto.UserDto;
import com.example.Jakub.Entity.UserInfo;
import com.example.Jakub.Mapper.UserMapper;
import com.example.Jakub.Repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserInfoRepository userRepository;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private UserMapper userMapper;

    public UserDto findByUsername(String username) {
        UserInfo user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ExpressionException("No such user"));
        return userMapper.toUserDto(user);
    }
    public UserDto login(AuthRequest authRequest) {
        System.out.println(authRequest.getUsername());
        System.out.println(authRequest.getPassword());
        UserInfo user = userRepository.findByUsername(authRequest.getUsername())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (securityConfig.passwordEncoder().matches((authRequest.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {
        System.out.println(userDto.getUsername());
        System.out.println(userDto.getPassword());
        Optional<UserInfo> optionalUser = userRepository.findByUsername(userDto.getUsername());

        if (optionalUser.isPresent()) {
            throw new AppException("This username already exists", HttpStatus.BAD_REQUEST);
        }

        UserInfo user = userMapper.signUpToUser(userDto);
        user.setPassword(securityConfig.passwordEncoder().encode(userDto.getPassword()));

        UserInfo savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public List<UserInfo> getListOfAllUsers(){
        List<UserInfo> listOfAllUsers = userRepository.findAll();
        return listOfAllUsers;
    }
}