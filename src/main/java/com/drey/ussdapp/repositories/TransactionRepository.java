package com.drey.ussdapp.repositories;

import com.drey.ussdapp.models.Transaction;
import com.drey.ussdapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserOrderByTimestampDesc(User user);
    List<Transaction> findByUser_PublicIdAndTimestampAfterOrderByTimestamp(UUID user_publicId, LocalDateTime timestamp);
    List<Transaction> findByUser_PublicIdAndAmount(UUID publicId,Double amount);

}