package app.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import app.domain.model.User;


public class UserClient {

    private static final String BASE_URL = "http://localhost:8080/users";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // Crear un nuevo usuario
        User newUser = new User();
        newUser.setName("Juan Pérez");
        ResponseEntity<User> createResponse = restTemplate.postForEntity(BASE_URL, newUser, User.class);
        User createdUser = createResponse.getBody();
        System.out.println("Usuario creado: " + createdUser);

        // Obtener el usuario por ID
        Long userId = createdUser.getId();
        User fetchedUser = restTemplate.getForObject(BASE_URL + "/" + userId, User.class);
        System.out.println("Usuario obtenido: " + fetchedUser);

        // Actualizar el usuario
        fetchedUser.setName("Juan Pérez actualizado");
        restTemplate.put(BASE_URL + "/" + userId, fetchedUser);
        System.out.println("Usuario actualizado: " + fetchedUser);

        // Eliminar el usuario
        restTemplate.delete(BASE_URL + "/" + userId);
        System.out.println("Usuario eliminado.");
    }
}