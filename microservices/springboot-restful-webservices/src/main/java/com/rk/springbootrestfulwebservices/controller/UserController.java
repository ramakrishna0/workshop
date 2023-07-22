package com.rk.springbootrestfulwebservices.controller;

import com.rk.springbootrestfulwebservices.dto.UserDto;
import com.rk.springbootrestfulwebservices.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // find user by id
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    //get all users
    //http://localhost:8080/api/users/
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUses() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //update user
    // http://localhost:8080/api/users/3
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody @Valid UserDto user) {
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //delete user
    @DeleteMapping("{id}")
    // http://localhost:8080/api/users/3
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    /*
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFound(ResourceNotFoundException exception,
                                                               WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    */
}
