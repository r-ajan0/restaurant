package com.example.restaurant.repository;

import com.example.restaurant.entity.User;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumberAndIdNot(String phoneNumber, Long id);



}
