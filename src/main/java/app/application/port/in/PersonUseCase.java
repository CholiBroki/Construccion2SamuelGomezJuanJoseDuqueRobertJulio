package app.application.port.in;

import app.domain.model.Person;
import java.util.List;

public interface PersonUseCase {
    void registerPerson(Person person);
    Person findByCedula(String cedula);
    List<Person> listAllPersons();
}