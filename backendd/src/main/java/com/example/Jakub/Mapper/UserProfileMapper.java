package com.example.Jakub.Mapper;

import com.example.Jakub.Dto.UserProfileDto;
import com.example.Jakub.Entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    UserProfileDto toUserProfileDto(UserProfile UserProfile);

    @Mapping(target = "userInfo", ignore = true)
    @Mapping(target = "profileId", ignore = true)
    UserProfile signUpToUserProfile(UserProfileDto userProfileDto);
}