package com.example.RESTAPI.repository;

import com.example.RESTAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


//springboot have three layer
//        1. Presentation Layer TodoController (manage, data return to ui, endpoint)
//        2. Service Layer TodoService (Logic, db data processing CRUD)
//        3. Persistance Layer TodoRepository (used to talk with db)


// used to chat with db
//Component mean TodoRepository will be managed by spring
public interface UserRepository extends JpaRepository<User, Long> {
 Optional<User> findByEmail(String email);
}
