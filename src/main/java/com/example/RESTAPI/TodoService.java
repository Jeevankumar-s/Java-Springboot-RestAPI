package com.example.RESTAPI;
import com.example.RESTAPI.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;


//Dependency - means class are required to get TodoService worked here TodoRepository is required to run the TodoService
//Inversion of controller means giving the dependency access to spring instead of doing manually Create and manage all the objects
//Bean - spring create objects and manage is known as


@Service
public class TodoService {
//    Autowire
    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo getTodoById(Long id){
        return todoRepository.findById(id).orElseThrow(()-> new RuntimeException("Todo not found: " + id));
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Page<Todo> getAllTodoPaginated(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return todoRepository.findAll(pageable);
    }

    public Todo updateTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public void deleteTodoById(Long id){
            todoRepository.deleteById(id);
    }
}
