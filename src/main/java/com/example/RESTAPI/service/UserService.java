package com.example.RESTAPI.service;
import com.example.RESTAPI.models.Todo;
import com.example.RESTAPI.models.User;
import com.example.RESTAPI.repository.TodoRepository;
import com.example.RESTAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


//Dependency - means class are required to get TodoService worked here TodoRepository is required to run the TodoService
//Inversion of controller means giving the dependency access to spring instead of doing manually Create and manage all the objects
//Bean - spring create objects and manage is known as


@Service
public class UserService {
//    Autowire
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found: " + "email"));
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
