package com.tuorg.materials.controller;

import com.tuorg.materials.dto.ApiResponse;
import com.tuorg.materials.dto.AuthRequest;
import com.tuorg.materials.dto.AuthResponse;
import com.tuorg.materials.security.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Simple auth controller issuing JWT for demo user.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final JwtUtils jwtUtils;
    public AuthController(JwtUtils jwtUtils) { this.jwtUtils = jwtUtils; }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody AuthRequest req) {
        log.info("Login attempt for user={}", req.getUsername());
        if ("admin".equals(req.getUsername()) && "password".equals(req.getPassword())) {
            String token = jwtUtils.generateToken(req.getUsername());
            return ResponseEntity.ok(new ApiResponse<>(200, "Login exitoso", new AuthResponse(token)));
        }
        log.warn("Login failed for user={}", req.getUsername());
        return ResponseEntity.status(401).body(new ApiResponse<>(401, "Credenciales invalidas", null));
    }
}
