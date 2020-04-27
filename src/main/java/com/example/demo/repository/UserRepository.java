package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username); 
}