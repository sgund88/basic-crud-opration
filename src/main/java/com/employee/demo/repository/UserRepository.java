package com.employee.demo.repository;

import com.employee.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Long> {
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}