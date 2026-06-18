package com.example.RESTAPI;
import org.springframework.stereotype.Component;

//springboot have three layer
//        1. Presentation Layer TodoController (manage, data return to ui, endpoint)
//        2. Service Layer TodoService (Logic, db data processing CRUD)
//        3. Persistance Layer TodoRepository (used to talk with db)


// used to chat with db
//Component mean TodoRepository will be managed by spring
@Component
public class TodoRepository {
    String getAllTodos(){
        return "Todos";
    }
}
