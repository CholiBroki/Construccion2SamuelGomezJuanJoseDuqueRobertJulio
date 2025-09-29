package Hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.adapter.in.user.Role;

import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Bienvenido al Sistema Hospitalario ===");

        Role role = new Role();
        role.menu();  
    }
}
