package app.adapter.in.controller;

import app.domain.model.User;
import app.domain.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@PreAuthorize("hasAnyRole('ADMIN', 'OWNER')") // Solo admins y owners pueden acceder
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    // Listar todos los usuarios
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            System.out.println("📋 Listando todos los usuarios...");
            List<User> users = userManagementService.listarUsuarios();
            System.out.println("✅ Total de usuarios encontrados: " + users.size());
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            System.err.println("❌ Error listando usuarios: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    // Buscar usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            System.out.println(" Buscando usuario con ID: " + id);
            Optional<User> user = userManagementService.obtenerUsuarioPorId(id);
            
            if (user.isPresent()) {
                System.out.println(" Usuario encontrado: " + user.get().getUsername() + " | Role: " + user.get().getRole());
                return ResponseEntity.ok(user.get());
            } else {
                System.out.println(" Usuario no encontrado con ID: " + id);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.err.println(" Error buscando usuario: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // Buscar usuario por username
    @GetMapping("/username/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        try {
            System.out.println(" Buscando usuario por username: " + username);
            User user = userManagementService.buscarPorUsername(username);
            
            if (user != null) {
                System.out.println(" Usuario encontrado: " + user.getUsername() + " | Role: " + user.getRole());
                return ResponseEntity.ok(user);
            } else {
                System.out.println(" Usuario no encontrado: " + username);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.err.println(" Error buscando usuario: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // Buscar usuarios por rol
    @GetMapping("/role/{role}")
    public ResponseEntity<?> getUsersByRole(@PathVariable String role) {
        try {
            System.out.println(" Buscando usuarios con rol: " + role);
            List<User> allUsers = userManagementService.listarUsuarios();
            
            List<User> filteredUsers = allUsers.stream()
                .filter(user -> user.getRole() != null && user.getRole().name().equalsIgnoreCase(role))
                .toList();
            
            System.out.println(" Encontrados " + filteredUsers.size() + " usuarios con rol " + role);
            return ResponseEntity.ok(filteredUsers);
        } catch (Exception e) {
            System.err.println(" Error buscando usuarios por rol: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        try {
            System.out.println("  Actualizando usuario ID: " + id);
            
            Optional<User> existingUserOpt = userManagementService.obtenerUsuarioPorId(id);
            if (existingUserOpt.isEmpty()) {
                System.out.println(" Usuario no encontrado con ID: " + id);
                return ResponseEntity.notFound().build();
            }
            
            User existingUser = existingUserOpt.get();
            
            // Actualizar solo los campos proporcionados
            if (updatedUser.getName() != null && !updatedUser.getName().isEmpty()) {
                existingUser.setName(updatedUser.getName());
            }
            if (updatedUser.getAge() > 0) {
                existingUser.setAge(updatedUser.getAge());
            }
            if (updatedUser.getDocument() != null && !updatedUser.getDocument().isEmpty()) {
                existingUser.setDocument(updatedUser.getDocument());
            }
            if (updatedUser.getRole() != null) {
                existingUser.setRole(updatedUser.getRole());
            }
            
            User saved = userManagementService.crearUsuario(existingUser);
            System.out.println(" Usuario actualizado: " + saved.getUsername());
            
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            System.err.println(" Error actualizando usuario: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            System.out.println("  Intentando eliminar usuario ID: " + id);
            
            Optional<User> userOpt = userManagementService.obtenerUsuarioPorId(id);
            if (userOpt.isEmpty()) {
                System.out.println(" Usuario no encontrado con ID: " + id);
                return ResponseEntity.notFound().build();
            }
            
            User user = userOpt.get();
            boolean deleted = userManagementService.eliminarUsuario(id);
            
            if (deleted) {
                System.out.println(" Usuario eliminado exitosamente: " + user.getUsername());
                return ResponseEntity.ok("Usuario eliminado exitosamente: " + user.getUsername());
            } else {
                System.out.println(" No se pudo eliminar el usuario");
                return ResponseEntity.badRequest().body("No se pudo eliminar el usuario");
            }
        } catch (Exception e) {
            System.err.println(" Error eliminando usuario: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}