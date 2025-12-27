package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        User saved = userService.register(user);
        String token = jwtUtil.generateToken(
                saved.getEmail(),
                saved.getRole(),
                saved.getId()
        );
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String email,
            @RequestParam String password) {

        User user = userService.login(email, password);
        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole(),
                user.getId()
        );
        return ResponseEntity.ok(token);
    }
}
