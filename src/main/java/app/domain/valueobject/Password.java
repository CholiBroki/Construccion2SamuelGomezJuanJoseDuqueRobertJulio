package app.domain.valueobject;

public class Password {
    private final String value;

    public Password(String value) {
        if (value == null || !value.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            throw new IllegalArgumentException("La contraseña debe incluir: 1 mayúscula, 1 número, 1 carácter especial y al menos 8 caracteres");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
