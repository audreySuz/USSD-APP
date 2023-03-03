package com.drey.ussdapp.domains.responses;

import com.drey.ussdapp.domains.enums.AccountType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserResponseDto {
    private UUID publicId;
    private String phoneNumber;
    private String accountName;
    private AccountType accountType;
    private double balance;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
