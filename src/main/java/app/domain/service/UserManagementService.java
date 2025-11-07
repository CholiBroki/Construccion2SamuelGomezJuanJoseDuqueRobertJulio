package app.domain.service;

import app.domain.model.User;
import app.adapter.out.UserAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de dominio encargado de la gestión de usuarios (CRUD).
 * Separa la lógica de negocio de la autenticación.
 */
@Service
@Transactional
public class UserManagementService {

    private final UserAdapter userAdapter;
    private final PasswordEncoder passwordEncoder;

    public UserManagementService(UserAdapter userAdapter, PasswordEncoder passwordEncoder) {
        this.userAdapter = userAdapter;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Crea un nuevo usuario, encriptando su contraseña antes de guardar.
     */
    public User crearUsuario(User user) {
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }

        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("La contraseña es obligatoria");
        }

        System.out.println("🔐 [UserManagementService] Encriptando contraseña para: " + user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        System.out.println("💾 [UserManagementService] Guardando usuario en BD...");
        User saved = userAdapter.save(user);

        System.out.println("✅ [UserManagementService] Usuario guardado con ID: " + saved.getId());
        return saved;
    }

    /**
     * Busca un usuario por su ID.
     */
    public Optional<User> obtenerUsuarioPorId(long id) {
        if (id <= 0) throw new IllegalArgumentException("ID inválido");
        System.out.println("🔍 [UserManagementService] Buscando usuario ID: " + id);
        return userAdapter.findById(id);
    }

    /**
     * Busca un usuario por su nombre de usuario.
     */
    public User buscarPorUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío");
        }
        System.out.println("🔍 [UserManagementService] Buscando username: " + username);
        return userAdapter.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + username));
    }

    /**
     * Lista todos los usuarios.
     */
    public List<User> listarUsuarios() {
        System.out.println("📋 [UserManagementService] Listando todos los usuarios");
        return userAdapter.findAll();
    }

    /**
     * Elimina un usuario por ID.
     */
    public boolean eliminarUsuario(long id) {
        if (id <= 0) throw new IllegalArgumentException("ID inválido");
        System.out.println("🗑️ [UserManagementService] Eliminando usuario ID: " + id);

        Optional<User> existing = userAdapter.findById(id);
        if (existing.isPresent()) {
            userAdapter.deleteById(id);
            System.out.println("✅ [UserManagementService] Usuario eliminado con éxito");
            return true;
        } else {
            System.out.println("⚠️ [UserManagementService] Usuario no encontrado, no se eliminó");
            return false;
        }
    }
}
