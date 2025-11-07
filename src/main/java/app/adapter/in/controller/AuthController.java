package app.adapter.in.controller;

import app.adapter.in.dto.ApiResponse;
import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.application.usecase.LoginUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private LoginUseCase loginUseCase;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthCredentials credentials) {
        try {
            System.out.println("🔐 Intento de login para usuario: " + credentials.getUsername());
            
            TokenResponse token = loginUseCase.login(credentials);
            
            System.out.println("✅ Login exitoso para: " + credentials.getUsername());
            
            return ResponseEntity.ok(ApiResponse.success("✅ Login exitoso", token));
            
        } catch (Exception e) {
            System.err.println("❌ Error en login: " + e.getMessage());
            return ResponseEntity
                .badRequest()
                .body(ApiResponse.error("Error de autenticación", e.getMessage()));
        }
    }
}