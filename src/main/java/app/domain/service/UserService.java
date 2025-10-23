package app.domain.service;

import org.springframework.stereotype.Service;
import app.domain.model.User;
import app.domain.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(User user) throws Exception {
        if (user == null) {
            throw new Exception("El usuario no puede ser nulo");
        }

        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new Exception("El nombre de usuario no puede estar vacío");
        }

        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.delete(id);
    }
}
