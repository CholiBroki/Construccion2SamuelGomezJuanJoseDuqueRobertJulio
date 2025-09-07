package app.domain.valueobject;

public class Username {
    private final String value;

    public Username(String value) {
        if (value == null || !value.matches("^[A-Za-z0-9]{1,15}$")) {
            throw new IllegalArgumentException("El nombre de usuario debe ser único, máx 15 caracteres, solo letras y números");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
