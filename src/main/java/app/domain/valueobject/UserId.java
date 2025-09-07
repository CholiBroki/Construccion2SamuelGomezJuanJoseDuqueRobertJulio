package app.domain.valueobject;

public class UserId {
    private final Id value;

    public UserId(String rawValue) {
        this.value = new Id(rawValue);
    }

    public String getValue() {
        return value.getValue();
    }

    @Override
    public String toString() {
        return value.getValue();
    }
}