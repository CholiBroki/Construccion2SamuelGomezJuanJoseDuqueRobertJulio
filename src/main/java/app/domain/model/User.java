package app.domain.model;

import app.domain.Enum.Role;
import app.domain.valueobject.*;

public class User {
    private final UserId id;
    private final Username username;
    private Password password;
    private Role role;

    public User(UserId id, Username username, Password password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserId getId() { return id; }
    public Username getUsername() { return username; }
    public Password getPassword() { return password; }
    public Role getRole() { return role; }

    public void changePassword(Password newPassword) {
        this.password = newPassword;
    }

    public void changeRole(Role newRole) {
        this.role = newRole;
    }
}