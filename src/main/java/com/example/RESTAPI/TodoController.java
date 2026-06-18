package com.example.RESTAPI;

import com.example.RESTAPI.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//Autowired - is used to automatic initialize (only with bean type parent managed by spring)
@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/all-todos")
    String getTodo() {
        return "Todos";
    }

    //  path variable
    @GetMapping("/{id}")
    ResponseEntity<?> getTodoById(@PathVariable Long id) {
        try {
            Todo todo = todoService.getTodoById(id);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //  Request Param
    @GetMapping("")
    String getSingleTodoWithParam(@RequestParam("todoID") int id) {
        return "Todos with id " + id;
    }

    //    Create Todo
    @PostMapping("/create")
    ResponseEntity<?> createTodo(@RequestBody Todo todo) {
        try {
            Todo createTodo = todoService.createTodo(todo);
            return new ResponseEntity<>(createTodo, HttpStatus.CREATED);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
