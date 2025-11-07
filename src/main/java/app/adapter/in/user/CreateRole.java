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

    public void session() throws Exception {
        boolean sessionActiva = true;
        while (sessionActiva) {
            sessionActiva = mostrarMenu();
        }
    }

    private boolean mostrarMenu() throws Exception {
        System.out.println(MENU);
        String opcion = reader.nextLine().trim();
        switch (opcion) {
            case "1" -> {
                User user = leerDatosUsuario();
                if (user != null) {
                    staffUseCase.crearDoctor(user);
                    System.out.println("✅ Doctor creado exitosamente.");
                }
                return true;
            }
            case "2" -> {
                User user = leerDatosUsuario();
                if (user != null) {
                    staffUseCase.crearEnfermero(user);
                    System.out.println("✅ Enfermero creado exitosamente.");
                }
                return true;
            }
            case "3" -> {
                System.out.println("👋 Hasta luego, cerrando sesión...");
                return false;
            }
            default -> {
                System.out.println("⚠️ Opción inválida. Intente nuevamente.");
                return true;
            }
        }
    }

    private User leerDatosUsuario() throws Exception {
        while (true) {
            try {
                System.out.println("Ingrese el nombre de la persona:");
                String nombre = validator.nameValidator(reader.nextLine().trim());

                System.out.println("Ingrese la cédula de la persona:");
                String documento = validator.validateDocument(reader.nextLine().trim());

                System.out.println("Ingrese el nombre de usuario:");
                String username = validator.userNameValidator(reader.nextLine().trim());

                System.out.println("Ingrese la contraseña:");
                String password = validator.passwordValidator(reader.nextLine().trim());

                System.out.println("Ingrese la edad de la persona:");
                String edadInput = reader.nextLine().trim();
                int edad = validator.ageValidator(edadInput);

                return userBuilder.build(nombre, documento, String.valueOf(edad), username, password);

            } catch (IllegalArgumentException e) {
                System.out.println("❌ Error de validación: " + e.getMessage());
                System.out.println("Por favor, intente nuevamente.\n");
            }
        }
    }
}