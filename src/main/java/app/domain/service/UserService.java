package app.domain.service;

import app.domain.model.User;
import app.adapter.out.UserAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserAdapter userAdapter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user) {
        // Solo encriptar si la contraseña no está ya encriptada
        if (!user.getPassword().startsWith("$2a$")) {
            System.out.println("🔐 Encriptando contraseña para: " + user.getUsername());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else {
            System.out.println("✅ Contraseña ya encriptada para: " + user.getUsername());
        }
        
        User saved = userAdapter.save(user);
        System.out.println("✅ Usuario guardado: " + saved.getUsername() + " con rol: " + saved.getRole());
        return saved;
    }

    public Optional<User> findById(long id) {
        return userAdapter.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        System.out.println("🔍 Buscando usuario: " + username);
        Optional<User> user = userAdapter.findByUsername(username);
        if (user.isPresent()) {
            System.out.println("✅ Usuario encontrado: " + username + " | Role: " + user.get().getRole());
        } else {
            System.out.println("❌ Usuario NO encontrado: " + username);
        }
        return user;
    }

    public List<User> findAll() {
        return userAdapter.findAll();
    }

    public boolean delete(long id) {
        Optional<User> user = userAdapter.findById(id);
        if (user.isPresent()) {
            userAdapter.deleteById(id);
            System.out.println("🗑️  Usuario eliminado: " + user.get().getUsername());
            return true;
        }
        return false;
    }

    public void create(User user) {
        save(user);
    }
}
