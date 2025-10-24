package app.adapter.in.user;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.adapter.in.builder.UserBuilder;
import app.adapter.in.validators.UserValidator;
import app.application.usecase.StaffUseCase;
import app.domain.model.User;

@Controller
public class CreateRole {

    private static final String MENU = """
        
        Ingrese una de las opciones:
        1. Crear Doctor
        2. Crear Enfermera
        3. Salir
        """;

    private static final Scanner reader = new Scanner(System.in);

    @Autowired
    private StaffUseCase staffUseCase;

    @Autowired
    private UserBuilder userBuilder;

    @Autowired
    private UserValidator validator;

    public void session() {
        boolean sessionActiva = true;
        while (sessionActiva) {
            sessionActiva = mostrarMenu();
        }
    }

    private boolean mostrarMenu() {
        try {
            System.out.println(MENU);
            String opcion = reader.nextLine();
            switch (opcion) {
                case "1" -> {
                    User user = leerDatosUsuario();
                    staffUseCase.crearDoctor(user);
                    return true;
                }
                case "2" -> {
                    User user = leerDatosUsuario();
                    staffUseCase.crearEnfermero(user);
                    return true;
                }
                case "3" -> {
                    System.out.println("Hasta luego, cerrando sesión...");
                    return false;
                }
                default -> {
                    System.out.println("Ingrese una opción válida");
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            return true;
        }
    }

    private User leerDatosUsuario() throws Exception {
        System.out.println("Ingrese el nombre de la persona:");
        String nombre = validator.nameValidator(reader.nextLine());

        System.out.println("Ingrese la cédula de la persona:");
        String documento = validator.validateDocument(reader.nextLine());

        System.out.println("Ingrese el nombre de usuario:");
        String username = validator.stringValidator("El nombre de usuario", reader.nextLine());

        System.out.println("Ingrese la contraseña:");
        String password = validator.stringValidator("La contraseña", reader.nextLine());

        System.out.println("Ingrese la edad de la persona:");
        String edadInput = reader.nextLine();
        int edad = validator.ageValidator(edadInput);

        return userBuilder.build(nombre, documento, String.valueOf(edad), username, password);
    }
}