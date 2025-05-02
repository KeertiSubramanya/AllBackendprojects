package com.dronezzfly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dronezzfly.model.UserRegistration;
import com.dronezzfly.requestdto.UserRequestDTO;
import com.dronezzfly.responsedto.UserResponseDTO;
import com.dronezzfly.service.UserService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create User
    @PostMapping("/save")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userService.saveUser(userRequestDTO);
    }

    // Retrieve All Users
    @GetMapping("/retrieve")
    public ResponseEntity<List<UserRegistration>> getAllUsers() {
        return userService.getAllRecords();
    }


    // Update User
    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateUser(id, userRequestDTO);
    }

    // Delete User (Soft Delete)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}