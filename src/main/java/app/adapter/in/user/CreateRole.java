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

    public static final String MENU = """
       
        Ingrese una de las opciones:
        1. Crear Doctor
        2. Crear Enfermera
        3. Salir
        """;

    public static Scanner reader = new Scanner(System.in);

    @Autowired
    private StaffUseCase staffUseCase;

    @Autowired
    private UserBuilder userBuilder;

    @Autowired
    private UserValidator validator; 

    public void session() {
        boolean session = true;
        while (session) {
            session = menu();
        }
    }

    public boolean menu() {
        try {
            System.out.println(MENU);
            String option = reader.nextLine();
            switch (option) {
                case "1" -> {
                    User user = readInfoFromUser();
                    staffUseCase.CreateDoctor(user);
                    return true;
                }
                case "2" -> {
                    User user = readInfoFromUser();
                    staffUseCase.createNurse(user);
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
            System.out.println(" Error: " + e.getMessage());
            return true;
        }
    }

    public User readInfoFromUser() throws Exception {
        System.out.println("Ingrese el nombre de la persona");
        String name = validator.nameValidator(reader.nextLine()); 
        System.out.println("Ingrese la cédula de la persona");
        String document = validator.validateDocument(reader.nextLine()); 
        System.out.println("Ingrese el nombre de usuario");
        String userName = validator.stringValidator("El nombre de usuario", reader.nextLine());
        System.out.println("Ingrese la contraseña");
        String password = validator.stringValidator("La contraseña", reader.nextLine());
        System.out.println("Ingrese la edad de la persona");
        String ageInput = reader.nextLine();
        int age = validator.ageValidator(ageInput);

        return userBuilder.build(name, document, String.valueOf(age), userName, password);
    }
}
