package com.munievents.munievents.repository;

import com.munievents.munievents.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import com.munievents.munievents.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findOneByEmail( String email);
}
