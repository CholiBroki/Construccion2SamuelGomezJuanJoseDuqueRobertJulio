package app.domain.valueobject;

public class Email {
    private final String value;

    public Email(String value) {
        if (value == null || !value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Correo electrónico inválido");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
