package com.drey.ussdapp.helpers;

import com.drey.ussdapp.domains.dtos.CreateUserDto;
import com.drey.ussdapp.domains.dtos.UpdateUserDto;
import com.drey.ussdapp.domains.responses.UserResponseDto;
import com.drey.ussdapp.models.User;

public class UserModelHelper {

    public static User toEntity(CreateUserDto dto) {
        User user = new User();
        user.setPublicId(dto.getPublicId());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPin(dto.getPin());
        user.setAccountName(dto.getAccountName());
        user.setAccountType(dto.getAccountType());
        user.setCreatedBy("system"); // Set default value
        user.setLastModifiedBy("system"); // Set default value
        return user;
    }

    public static void merge(UpdateUserDto dto, User user) {
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPin(dto.getPin());
        user.setAccountName(dto.getAccountName());
        user.setAccountType(dto.getAccountType());
        user.setLastModifiedBy("system"); // Set default value
    }

    public static UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setPublicId(user.getPublicId());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setAccountName(user.getAccountName());
        dto.setAccountType(user.getAccountType());
        dto.setBalance(user.getBalance());
        dto.setCreatedDate(user.getCreatedDate());
        dto.setLastModifiedDate(user.getLastModifiedDate());
        return dto;
    }
}
