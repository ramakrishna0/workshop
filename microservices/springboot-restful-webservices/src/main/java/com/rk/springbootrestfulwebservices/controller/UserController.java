package com.rk.springbootrestfulwebservices.controller;

import com.rk.springbootrestfulwebservices.entity.User;
import com.rk.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    //    @Autowired //can be omitted for single instance variable class
    private UserService userService;

    //build create user REST API
    // http://localhost:8080/api/users/create
    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // find user by id
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    //get all users
    //http://localhost:8080/api/users/
    @GetMapping
    public ResponseEntity<List<User>> getAllUses() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //update user
    // http://localhost:8080/api/users/3
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user) {
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //delete user
    @DeleteMapping("{id}")
    // http://localhost:8080/api/users/3
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
