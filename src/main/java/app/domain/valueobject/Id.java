package app.domain.valueobject;

public class Id {
    private final String value;

    public Id(String value){
        if (value == null || value.isBlank()){
            throw new IllegalArgumentException("La cédula no puede estar vacía");
        }
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}