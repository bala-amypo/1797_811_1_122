package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    /**
     * Generates a simple JWT-like token.
     * Format: email.role.userId
     */
    public String generateToken(String email, String role, Long userId) {
        return email + "." + role + "." + userId;
    }

    /**
     * Validates token format.
     */
    public boolean validateToken(String token) {
        return token != null && token.split("\\.").length == 3;
    }

    /**
     * Extract email from token.
     */
    public String extractEmail(String token) {
        return token.split("\\.")[0];
    }

    /**
     * Extract role from token.
     */
    public String extractRole(String token) {
        return token.split("\\.")[1];
    }

    /**
     * Extract userId from token.
     */
    public Long extractUserId(String token) {
        return Long.parseLong(token.split("\\.")[2]);
    }
}
