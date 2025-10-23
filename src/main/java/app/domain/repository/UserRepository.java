package app.domain.repository;

import app.domain.model.User;
import java.util.Optional;
import java.util.List;

public interface UserRepository {
    void save(User user);
    void delete(long id);
    Optional<User> findById(long id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
}

