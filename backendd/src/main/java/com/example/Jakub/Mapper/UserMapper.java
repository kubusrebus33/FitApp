package com.example.Jakub.Mapper;

import com.example.Jakub.Dto.SignUpDto;
import com.example.Jakub.Dto.UserDto;
import com.example.Jakub.Entity.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(UserInfo userInfo);

    @Mapping(target = "password", ignore = true)
    UserInfo signUpToUser(SignUpDto signUpDto);
}