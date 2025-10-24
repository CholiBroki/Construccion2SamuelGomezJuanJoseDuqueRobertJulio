package app.domain.service;

import app.domain.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManagementService {

    @Autowired
    private UserService userService;

    public User crearUsuario(User user) {
        return userService.save(user);
    }

    public Optional<User> obtenerUsuarioPorId(long id) {
        return userService.findById(id);
    }

    public User buscarPorUsername(String username) {
        return userService.findByUsername(username);
    }

    public List<User> listarUsuarios() {
        return userService.findAll();
    }

    public boolean eliminarUsuario(long id) {
        return userService.delete(id);
    }
}