package com.munievents.munievents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.munievents.munievents.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
