package com.drey.ussdapp.services;

import com.drey.ussdapp.domains.dtos.CreateUserDto;
import com.drey.ussdapp.models.User;
import com.drey.ussdapp.responses.AppResponse;

import java.util.UUID;

public interface UserService {
     AppResponse createUser(CreateUserDto createUserDto, String authKey);

    AppResponse getUserByPhoneNumber(String phoneNumber, String authKey);

    AppResponse getUserByPublicId(UUID publicId, String authKey);

    AppResponse deposit(String pin, double amount, String authKey);

    AppResponse withdraw(String pin, double amount, String authKey);

    AppResponse getBalance(String pin, String authKey);
}
