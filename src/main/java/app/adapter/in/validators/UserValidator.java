package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public String nameValidator(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (!name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras");
        }
        return name.trim();
    }

    public String validateDocument(String document) {
        if (document == null || document.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede estar vacía");
        }
        if (!document.matches("\\d+")) {
            throw new IllegalArgumentException("La cédula debe contener solo números");
        }
        return document.trim();
    }

    public int ageValidator(String age) {
        try {
            int value = Integer.parseInt(age);
            if (value <= 0 || value > 120) {
                throw new IllegalArgumentException("La edad debe estar entre 1 y 120 años");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La edad debe ser un número válido");
        }
    }

    public String userNameValidator(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío");
        }
        if (userName.length() < 6) {
            throw new IllegalArgumentException("El nombre de usuario debe tener al menos 6 caracteres");
        }
        if (userName.matches(".*[áéíóúÁÉÍÓÚ].*")) {
            throw new IllegalArgumentException("El nombre de usuario no puede contener tildes");
        }
        return userName.trim();
    }

    public String passwordValidator(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres");
        }
        return password.trim();
    }
}
