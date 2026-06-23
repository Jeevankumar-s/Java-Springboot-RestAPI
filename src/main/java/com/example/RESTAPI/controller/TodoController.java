package com.example.RESTAPI.controller;

import com.example.RESTAPI.models.Todo;
import com.example.RESTAPI.service.TodoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Autowired - is used to automatic initialize (only with bean type parent managed by spring)
@RestController
@RequestMapping("/todos")
@Slf4j
public class TodoController {
    @Autowired
    private TodoService todoService;

    //    GET All todo
    @GetMapping("")
    ResponseEntity<List<Todo>> getAllTodo() {
        return new ResponseEntity<List<Todo>>(todoService.getAllTodos(), HttpStatus.OK);
    }

    //    GET All todo based on pagination
    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getAllTodoByPagination(@RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<Page<Todo>>(todoService.getAllTodoPaginated(page, size), HttpStatus.OK);
    }

    //  GET single todo by ID
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Todo fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Todo not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<?> getTodoById(@PathVariable Long id) {
        try {
            Todo todo = todoService.getTodoById(id);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (RuntimeException exception) {
            log.error("Todo not found", exception);
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
            log.error("Unable to create Todo", exception);
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
        } catch (RuntimeException exception) {
            log.error("Unable to delete Todo", exception);
            return "Unable to delete Todo" + exception;
        }
    }
}
