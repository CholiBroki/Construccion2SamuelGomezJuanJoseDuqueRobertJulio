package app.domain.repository;

import app.domain.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Person guardar(Person person);
    Optional<Person> buscarPorCedula(String cedula);
    List<Person> listarTodos();
}