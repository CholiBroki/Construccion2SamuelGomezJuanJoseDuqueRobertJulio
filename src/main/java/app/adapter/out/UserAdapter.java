package app.adapter.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.repository.UserRepository;

@Service
public class UserAdapter implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
        System.out.println("✅ Usuario creado: " + user.getUsername());
    }

    @Override
    public void delete(long id) {
        users.removeIf(u -> u.getId() == id);
        System.out.println("🗑️ Usuario con ID " + id + " eliminado");
    }

    @Override
    public Optional<User> findById(long id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
