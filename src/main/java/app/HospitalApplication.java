package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import app.adapter.in.user.CreateRole;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {

    @Autowired
    private CreateRole createRole;

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bienvenido al Sistema Hospitalario");
        createRole.session();
    }
}
