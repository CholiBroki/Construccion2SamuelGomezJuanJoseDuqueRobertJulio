package app.adapter.in.dto;

import app.domain.Enum.Role;
import app.domain.model.User;

public class UserResponse {
    private Long id;
    private String name;
    private String username;
    private Integer age;
    private String document;
    private Role role;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.age = user.getAge();
        this.document = user.getDocument();
        this.role = user.getRole();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public String getDocument() {
        return document;
    }

    public Role getRole() {
        return role;
    }
}