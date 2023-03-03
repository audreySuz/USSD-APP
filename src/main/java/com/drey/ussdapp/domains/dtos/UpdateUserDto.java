package com.drey.ussdapp.domains.dtos;

import com.drey.ussdapp.domains.enums.AccountType;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateUserDto {
    private UUID publicId;
    private String phoneNumber;
    private String pin;
    private String accountName;
    private AccountType accountType;
}