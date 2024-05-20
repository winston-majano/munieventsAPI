package com.munievents.munievents.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.munievents.munievents.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findOneByEmail(String email);
    List<User> findByStatus(String status);
    Optional<User> findByIdAndStatus(int id, String status);
    Optional<User> findOneByEmailAndStatus(String email, String status);
}
