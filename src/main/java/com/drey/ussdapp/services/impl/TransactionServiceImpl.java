package com.drey.ussdapp.services.impl;

import com.drey.ussdapp.models.Transaction;
import com.drey.ussdapp.models.User;
import com.drey.ussdapp.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl {
    private final TransactionRepository transactionRepository;

    public List<Transaction> getTransactions(User user) {
        return transactionRepository.findByUserOrderByTimestampDesc(user);
    }
}