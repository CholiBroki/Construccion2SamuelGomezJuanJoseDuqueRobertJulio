package app.domain.model;

public class Seller extends Person {
    private String usuario;
    private String contrasena;

    public Seller(String cedula, String nombre, int edad, String usuario, String contrasena) {
        super(cedula, nombre, edad, "VENDEDOR");
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