package app.domain.model;

public class Pet {
    private String id; // ID único asignado por el sistema
    private String nombre;
    private String cedulaDueno;
    private int edad;
    private String especie;
    private String raza;
    private String caracteristicas; // color, tamaño, etc.
    private double peso;

    public Pet(String id, String nombre, String cedulaDueno, int edad, String especie, String raza, String caracteristicas, double peso) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID no puede estar vacío");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (cedulaDueno == null || cedulaDueno.isBlank()) {
            throw new IllegalArgumentException("La cédula del dueño no puede estar vacía");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que 0");
        }
        this.id = id;
        this.nombre = nombre;
        this.cedulaDueno = cedulaDueno;
        this.edad = edad;
        this.especie = especie;
        this.raza = raza;
        this.caracteristicas = caracteristicas;
        this.peso = peso;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedulaDueno() {
        return cedulaDueno;
    }

    public int getEdad() {
        return edad;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public double getPeso() {
        return peso;
    }
}