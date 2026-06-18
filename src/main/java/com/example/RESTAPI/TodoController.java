package com.example.RESTAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//Autowired - is used to automatic initialize (only with bean type parent managed by spring)
@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/all-todos")
    String getTodo() {
        todoService.getTodo();
        return "Todos";
    }

    //  path variable
    @GetMapping("/{id}")
    String getSingleTodo(@PathVariable int id) {
        return "Todos with id " + id;
    }

    //  Request Param
    @GetMapping("")
    String getSingleTodoWithParam(@RequestParam("todoID") int id) {
        return "Todos with id " + id;
    }

    //    Create User
    @PostMapping("/create-user")
    String createUser(@RequestBody String body) {
//        return "User Created with name "+ ;
        return body;
    }
}
