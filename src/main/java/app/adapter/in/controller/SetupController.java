package app.adapter.in.controller;

import app.domain.Enum.Role;
import app.domain.model.User;
import app.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * ⚠️ CONTROLADOR TEMPORAL PARA SETUP INICIAL
 * Eliminar después de crear el usuario admin en producción
 */
@RestController
@RequestMapping("/api/setup")
public class SetupController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create-admin")
    public ResponseEntity<?> createInitialAdmin() {
        try {
            // Verificar si ya existe
            if (userService.findByUsername("admin123").isPresent()) {
                return ResponseEntity.badRequest().body(
                    createResponse(false, "El usuario admin123 ya existe. Usa /api/setup/reset-admin para recrearlo.")
                );
            }

            // Crear usuario admin
            User admin = new User();
            admin.setName("Administrador Sistema");
            admin.setUsername("admin123");
            admin.setPassword("password"); // Se encriptará automáticamente en UserService
            admin.setAge(30);
            admin.setRole(Role.OWNER);
            admin.setDocument("123456789");

            User created = userService.save(admin);

            System.out.println(" Usuario admin creado exitosamente");
            System.out.println("   ID: " + created.getId());
            System.out.println("   Username: " + created.getUsername());
            System.out.println("   Role: " + created.getRole());

            return ResponseEntity.ok(createResponse(true, 
                "✅ Usuario admin creado exitosamente. " +
                "Credenciales: admin123 / password", created));

        } catch (Exception e) {
            System.err.println(" Error creando admin: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body(
                createResponse(false, "Error: " + e.getMessage())
            );
        }
    }

    @PostMapping("/reset-admin")
    public ResponseEntity<?> resetAdmin() {
        try {
            System.out.println("Iniciando reset de admin...");
            
            // Buscar y eliminar admin anterior
            userService.findByUsername("admin123").ifPresent(user -> {
                userService.delete(user.getId());
                System.out.println("  Usuario admin anterior eliminado (ID: " + user.getId() + ")");
            });

            // Crear nuevo admin
            User admin = new User();
            admin.setName("Administrador Sistema");
            admin.setUsername("admin123");
            admin.setPassword("password"); // Contraseña en texto plano, se encriptará automáticamente
            admin.setAge(30);
            admin.setRole(Role.OWNER);
            admin.setDocument("123456789");

            User created = userService.save(admin);

            System.out.println("✅ Usuario admin recreado exitosamente");
            System.out.println("   ID: " + created.getId());
            System.out.println("   Username: " + created.getUsername());
            System.out.println("   Role: " + created.getRole());
            
            return ResponseEntity.ok(createResponse(true, 
                " Usuario admin recreado exitosamente. " +
                "Ahora puedes hacer login con: admin123 / password", created));

        } catch (Exception e) {
            System.err.println(" Error: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body(
                createResponse(false, "Error: " + e.getMessage())
            );
        }
    }

    @GetMapping("/test-password")
    public ResponseEntity<?> testPassword(@RequestParam String password) {
        try {
            String encrypted = passwordEncoder.encode(password);
            
            Map<String, Object> result = new HashMap<>();
            result.put("original", password);
            result.put("encrypted", encrypted);
            result.put("length", encrypted.length());
            result.put("matches", passwordEncoder.matches(password, encrypted));
            
            System.out.println("🔐 Test de encriptación:");
            System.out.println("   Original: " + password);
            System.out.println("   Encriptada: " + encrypted);
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                createResponse(false, "Error: " + e.getMessage())
            );
        }
    }

    @GetMapping("/verify-admin")
    public ResponseEntity<?> verifyAdmin() {
        try {
            var userOpt = userService.findByUsername("admin123");
            
            if (userOpt.isEmpty()) {
                return ResponseEntity.ok(createResponse(false, 
                    " El usuario admin123 NO existe en la base de datos. " +
                    "Ejecuta /api/setup/create-admin para crearlo."));
            }
            
            User user = userOpt.get();
            
            Map<String, Object> info = new HashMap<>();
            info.put("exists", true);
            info.put("id", user.getId());
            info.put("username", user.getUsername());
            info.put("name", user.getName());
            info.put("role", user.getRole());
            info.put("age", user.getAge());
            info.put("document", user.getDocument());
            info.put("passwordPrefix", user.getPassword().substring(0, 10) + "...");
            info.put("message", " El usuario admin123 existe y está listo para usar");
            
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                createResponse(false, "Error: " + e.getMessage())
            );
        }
    }

    private Map<String, Object> createResponse(boolean success, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("message", message);
        return response;
    }

    private Map<String, Object> createResponse(boolean success, String message, User user) {
        Map<String, Object> response = createResponse(success, message);
        Map<String, Object> userData = new HashMap<>();
        userData.put("id", user.getId());
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("role", user.getRole());
        userData.put("age", user.getAge());
        userData.put("document", user.getDocument());
        response.put("user", userData);
        return response;
    }
}