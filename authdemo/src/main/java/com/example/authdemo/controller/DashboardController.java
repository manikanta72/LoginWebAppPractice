package com.example.authdemo.controller;

import com.example.authdemo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @GetMapping
    public Map<String, String> dashboard(
            @RequestHeader("Authorization") String authHeader) {

        String token = authHeader.replace("Bearer ", "");
        String email = JwtUtil.validateToken(token);

        return Map.of(
                "message", "Welcome to Dashboard",
                "user", email
        );
    }
}