package com.blibli.future.todolist.controller;

import com.blibli.future.todolist.exception.ResourceNotFoundException;
import com.blibli.future.todolist.model.User;
import com.blibli.future.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{userName}")
    public Optional<User> getUserDetail(@PathVariable String userName) {
        return userRepository.findById(userName);
    }


    @PostMapping("/users/register")
    public User createUser(@Valid @RequestBody User user) {

        if(!userRepository.existsById(user.getUserName()))
        {
            return userRepository.save(user);
        }
       throw new ResourceNotFoundException("User already exist with username " + user.getUserName());
    }


    @PutMapping("/users/{userName}/update")
    public User updateUser(@PathVariable String userName,
                           @Valid @RequestBody User userRequest) {
        return userRepository.findById(userName)
                .map(user -> {
                    user.setFullName(userRequest.getFullName());
                    return userRepository.save(user);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with username " + userName));
    }


    @DeleteMapping("/users/{userName}/delete")
    public ResponseEntity<?> deleteUser(@PathVariable String userName) {
        return userRepository.findById(userName)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with username " + userName));
    }
}
