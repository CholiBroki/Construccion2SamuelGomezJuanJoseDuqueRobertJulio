package app.domain.valueobject;

public class Phone {
    private final String value;

    public Phone(String value) {
        if (value == null || !value.matches("^\\d{1,10}$")) {
            throw new IllegalArgumentException("Número de teléfono inválido (máx 10 dígitos)");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
