package com.example.RESTAPI;

import com.example.RESTAPI.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Autowired - is used to automatic initialize (only with bean type parent managed by spring)
@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    //    GET All todo
    @GetMapping("")
    ResponseEntity<List<Todo>> getAllTodo() {
        return new ResponseEntity<List<Todo>>(todoService.getAllTodos(), HttpStatus.OK);
    }

    //  GET single todo by ID
    @GetMapping("/{id}")
    ResponseEntity<?> getTodoById(@PathVariable Long id) {
        try {
            Todo todo = todoService.getTodoById(id);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
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

    @PutMapping("")
    ResponseEntity<Todo> updateTodoById(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.updateTodo(todo), HttpStatus.OK);
    }

    //    Delete Todo by ID
    @DeleteMapping("/{id}")
    String deleteTodoByID(@PathVariable Long id) {
        try {
            todoService.deleteTodoById(id);
            return "Todo Deleted Successfullt" + id;
        } catch (RuntimeException exceptione) {
            return "Unable to delete Todo" + exceptione;
        }
    }
}
