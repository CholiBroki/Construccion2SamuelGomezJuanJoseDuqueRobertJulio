package app.domain.model;

public class Veterinarian extends Person {
    private String usuario;
    private String contrasena;

    public Veterinarian(String cedula, String nombre, int edad, String usuario, String contrasena) {
        super(cedula, nombre, edad, "VETERINARIO");
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
}