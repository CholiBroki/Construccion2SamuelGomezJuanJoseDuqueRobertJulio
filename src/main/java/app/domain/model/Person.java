package app.domain.model;

public abstract class Person {
    private String cedula;
    private String nombre;
    private int edad;
    private String rol;

    public Person(String cedula, String nombre, int edad, String rol) {
        if (cedula == null || cedula.isBlank()) {
            throw new IllegalArgumentException("La cédula no puede estar vacía");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor a 0");
        }
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.rol = rol;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getRol() {
        return rol;
    }
}