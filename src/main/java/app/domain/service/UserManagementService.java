package app.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.domain.model.User;
import app.domain.Enum.Role;
import app.domain.repository.UserRepository;

@Service
public class UserManagementService {

    private final UserRepository userRepository;

    @Autowired
    public UserManagementService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) throws Exception {
        // ✅ Verifica si ya existe un usuario con la misma cédula (ID)
        if (userRepository.findById(user.getId()).isPresent()) {
            throw new Exception("Error: ya existe una persona registrada con esa cédula");
        }

        // ✅ Verifica si ya existe un usuario con el mismo nombre de usuario
        if (!user.getRole().equals(Role.OWNER) &&
            userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new Exception("Error: ya existe una persona registrada con ese nombre de usuario");
        }

        // ✅ Guarda el nuevo usuario
        userRepository.save(user);
    }
}
