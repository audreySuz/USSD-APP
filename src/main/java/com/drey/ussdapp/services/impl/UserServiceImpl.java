package com.drey.ussdapp.services.impl;

import com.drey.ussdapp.domains.dtos.CreateUserDto;
import com.drey.ussdapp.domains.responses.UserResponseDto;
import com.drey.ussdapp.exceptions.InsufficientBalanceException;
import com.drey.ussdapp.exceptions.NotFoundException;
import com.drey.ussdapp.helpers.UserModelHelper;
import com.drey.ussdapp.models.Transaction;
import com.drey.ussdapp.models.User;
import com.drey.ussdapp.repositories.TransactionRepository;
import com.drey.ussdapp.repositories.UserRepository;
import com.drey.ussdapp.responses.AppResponse;
import com.drey.ussdapp.services.UserService;
import com.drey.ussdapp.utils.AdminAuthKeyValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final AdminAuthKeyValidator adminAuthKeyValidator;

    @Override
    public AppResponse createUser(CreateUserDto createUserDto, String authKey) {
        adminAuthKeyValidator.validateAdminAuthKey(authKey);
        createUserDto.setPublicId(UUID.randomUUID());
        User savedUser = userRepository.save(UserModelHelper.toEntity(createUserDto));
        return new AppResponse(HttpStatus.CREATED.value(), "User created successfully", null, savedUser, null);
    }

    @Override
    public AppResponse getUserByPhoneNumber(String phoneNumber, String authKey) {
        adminAuthKeyValidator.validateAdminAuthKey(authKey);
        User user = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new NotFoundException("User not found"));
        UserResponseDto userResponseDto = UserModelHelper.toDto(user);
        return new AppResponse(HttpStatus.OK.value(), "User found successfully", null, userResponseDto, null);
    }

    @Override
    public AppResponse getUserByPublicId(UUID publicId, String authKey) {
        adminAuthKeyValidator.validateAdminAuthKey(authKey);
        User user = userRepository.findByPublicId(publicId)
                .orElseThrow(() -> new NotFoundException("User not found"));
        UserResponseDto userResponseDto = UserModelHelper.toDto(user);
        return new AppResponse(HttpStatus.OK.value(), "User found successfully", null, userResponseDto, null);

    }

    private User getUserByPin(String pin) {
        return userRepository.findByPin(pin)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public AppResponse deposit(String pin, double amount, String authKey) {
        adminAuthKeyValidator.validateUserAuthKey(authKey);
        User user = getUserByPin(pin);
        user.setBalance(user.getBalance() + amount);
        User savedUser = userRepository.save(user);
        saveTransaction(savedUser, "DEPOSIT", amount);
        return new AppResponse(HttpStatus.OK.value(), "Amount deposited successfully", null,  UserModelHelper.toDto(savedUser), null);
    }

    @Override
    public AppResponse withdraw(String pin, double amount, String authKey) {
        adminAuthKeyValidator.validateUserAuthKey(authKey);
        User user = getUserByPin(pin);
        if (user.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        user.setBalance(user.getBalance() - amount);
        User savedUser = userRepository.save(user);
        saveTransaction(savedUser, "WITHDRAWAL", -amount);
        return new AppResponse(HttpStatus.OK.value(), "Amount withdrawn successfully", null,  UserModelHelper.toDto(savedUser), null);
    }

    @Override
    public AppResponse getBalance(String pin, String authKey) {
        adminAuthKeyValidator.validateUserAuthKey(authKey);
        Double balance = getUserByPin(pin).getBalance();
        return new AppResponse(HttpStatus.OK.value(), "Balance fetched successfully", null, balance, null);
    }


    private void saveTransaction(User user, String type, double amount) {
        Transaction transaction = new Transaction();
        transaction.setType(type);
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setUser(user);
        transactionRepository.save(transaction);
    }
}