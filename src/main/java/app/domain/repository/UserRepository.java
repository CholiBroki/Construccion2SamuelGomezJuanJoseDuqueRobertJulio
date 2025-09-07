package app.domain.repository;

import app.domain.model.User;
import app.domain.valueobject.Id;
import app.domain.valueobject.UserId;

import java.util.Optional;
import java.util.List;

public interface UserRepository {
    void save(User user);
    void delete(UserId id);
    Optional<User> findById(UserId id);
    void delete(Id id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
}
