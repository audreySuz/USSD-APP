package com.drey.ussdapp.repositories;

import com.drey.ussdapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);
    Optional<User> findByPublicId(UUID publicId);
    Optional<User> findByPin(String pin);


}