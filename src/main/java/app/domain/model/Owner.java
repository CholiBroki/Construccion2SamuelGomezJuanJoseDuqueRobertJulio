package app.domain.model;

public class Owner extends Person {

    public Owner(String cedula, String nombre, int edad) {
        super(cedula, nombre, edad, "DUEÑO");
    }
}