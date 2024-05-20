package com.elevengroup.watch.controller.api;

import com.elevengroup.watch.entity.UserDto;
import com.elevengroup.watch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthApi {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ResponseEntity<?> loginUser() {
        return ResponseEntity.ok("Login successful");
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        try {
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userService.save(userDto);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging purposes
            return ResponseEntity.status(500).body("An error occurred while registering the account");
        }
    }
}
