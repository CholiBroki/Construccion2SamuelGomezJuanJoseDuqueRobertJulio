package app.adapter.in.controller;

import app.application.usecase.AdminUseCase;
import app.domain.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminUseCase adminUseCase;

    @PostMapping("/users/doctor")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<?> createDoctor(@RequestBody User user) {
        try {
            System.out.println("👨‍⚕️ Creando doctor: " + user.getUsername());
            User created = adminUseCase.createDoctor(user);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("❌ Error creando doctor: " + e.getMessage());
            return ResponseEntity.badRequest().body("❌ Error: " + e.getMessage());
        }
    }

    @PostMapping("/users/seller")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<?> createSeller(@RequestBody User user) {
        try {
            System.out.println(" Creando paciente: " + user.getUsername());
            User created = adminUseCase.createSeller(user);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println(" Error creando paciente: " + e.getMessage());
            return ResponseEntity.badRequest().body("❌ Error: " + e.getMessage());
        }
    }

    @PostMapping("/users/nurse")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<?> createNurse(@RequestBody User user) {
        try {
            System.out.println(" Creando enfermera: " + user.getUsername());
            User created = adminUseCase.createNurse(user);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println(" Error creando enfermera: " + e.getMessage());
            return ResponseEntity.badRequest().body("❌ Error: " + e.getMessage());
        }
        
    }
    
    
}