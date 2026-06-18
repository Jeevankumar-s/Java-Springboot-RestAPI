package com.example.RESTAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


//Dependency - means class are required to get TodoService worked here TodoRepository is required to run the TodoService
//Inversion of controller means giving the dependency access to spring instead of doing manually Create and manage all the objects
//Bean - spring create objects and manage is known as


@Service
public class TodoService {
//    Autowire
    @Autowired
    private TodoRepository todoRepository;
    public void getTodo(){
        System.out.println(todoRepository.getAllTodos());
    }
}
