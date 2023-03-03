package com.drey.ussdapp.models;

import com.drey.ussdapp.domains.enums.AccountType;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID publicId;
    private String phoneNumber;
    private String pin;
    private double balance;
    private String accountName;
    private AccountType accountType;
    private String createdBy;
    private String lastModifiedBy;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private BigInteger version;
}

