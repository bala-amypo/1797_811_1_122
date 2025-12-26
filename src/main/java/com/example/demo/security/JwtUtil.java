package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    /**
     * Generates a JWT token using user details.
     * In a real application, this would include signing and expiry.
     */
    public String generateToken(String email, String role, Long userId) {
        return email + "." + role + "." + userId;
    }

    /**
     * Validates the given JWT token.
     */
    public boolean validateToken(String token) {
        return token != null && token.split("\\.").length == 3;
    }

    /**
     * Extracts email from token.
     */
    public String extractEmail(String token) {
        return token.split("\\.")[0];
    }

    /**
     * Extracts role from token.
     */
    public String extractRole(String token) {
        return token.split("\\.")[1];
    }

    /**
     * Extracts user ID from token.
     */
    public Long extractUserId(String token) {
        return Long.parseLong(token.split("\\.")[2]);
    }
}
