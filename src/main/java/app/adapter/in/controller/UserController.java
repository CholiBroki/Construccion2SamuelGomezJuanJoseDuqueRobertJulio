package app.adapter.in.controller;

import app.domain.model.User;
import app.domain.service.UserManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errores = result.getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
            return ResponseEntity.badRequest().body(errores);
        }

        User creado = userManagementService.crearUsuario(user);
        return ResponseEntity.ok(creado);
    }

    @GetMapping
    public ResponseEntity<List<User>> listarUsuarios() {
        return ResponseEntity.ok(userManagementService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorUsuario(@PathVariable Long id){
        Optional<User> usuarioOptional = userManagementService.obtenerUsuarioPorId(id);
        if(usuarioOptional.isPresent()){
            return ResponseEntity.ok(usuarioOptional.get());
        } else {
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> buscarPorUsername(@RequestParam String username) {
        Optional<User> usuario = userManagementService.buscarPorUsername(username);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.status(404).body("Usuario no encontrado con username: " + username);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable long id) {
        boolean eliminado = userManagementService.eliminarUsuario(id);
        if (eliminado) {
            return ResponseEntity.ok("Usuario eliminado con éxito");
        } else {
            return ResponseEntity.status(404).body("Usuario no encontrado con ID: " + id);
        }
    }
}