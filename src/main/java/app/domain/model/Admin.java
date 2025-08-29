package app.domain.model;

public class Admin extends Person {
    private String usuario;
    private String contrasena;

    public Admin(String cedula, String nombre, int edad, String usuario, String contrasena) {
        super(cedula, nombre, edad, "ADMIN");
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