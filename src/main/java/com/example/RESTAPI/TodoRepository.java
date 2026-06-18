package com.example.RESTAPI;
import com.example.RESTAPI.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

//springboot have three layer
//        1. Presentation Layer TodoController (manage, data return to ui, endpoint)
//        2. Service Layer TodoService (Logic, db data processing CRUD)
//        3. Persistance Layer TodoRepository (used to talk with db)


// used to chat with db
//Component mean TodoRepository will be managed by spring
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
