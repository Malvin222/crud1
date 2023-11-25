package com.crud1.crud1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud1.crud1.domain.User;


public interface UserRepository extends JpaRepository<User, Long> {
    
}
