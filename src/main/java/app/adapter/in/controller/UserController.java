package app.adapter.in.controller;

import app.domain.model.User;
import app.domain.service.UserManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody User user, BindingResult result) {
        System.out.println("📥 [UserController] Recibido usuario: " + user.getUsername());
        
        if (result.hasErrors()) {
            List<String> errores = result.getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
            System.out.println("❌ [UserController] Errores de validación: " + errores);
            return ResponseEntity.badRequest().body(errores);
        }

        try {
            // ✅ NO encriptar aquí - lo hace el service
            User creado = userManagementService.crearUsuario(user);
            System.out.println(" [UserController] Usuario creado con ID: " + creado.getId());
            return ResponseEntity.status(201).body(creado);
        } catch (Exception e) {
            System.err.println(" [UserController] Error: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al crear usuario: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> listarUsuarios() {
        System.out.println(" [UserController] Listando todos los usuarios");
        List<User> usuarios = userManagementService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable Long id) {
        System.out.println(" [UserController] Buscando usuario ID: " + id);
        return userManagementService.obtenerUsuarioPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        System.out.println(" [UserController] Eliminando usuario ID: " + id);
        boolean eliminado = userManagementService.eliminarUsuario(id);
        if (eliminado) {
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        }
        return ResponseEntity.notFound().build();
    }
}