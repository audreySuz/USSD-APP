package com.drey.ussdapp.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double amount;
    private LocalDateTime timestamp;
    @ManyToOne
    private User user;
}