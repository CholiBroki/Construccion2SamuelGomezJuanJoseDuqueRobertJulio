package app.domain.service;

import app.domain.model.*;
import app.domain.repository.PersonRepository;
import app.domain.repository.PetRepository;

import java.util.List;
import java.util.Optional;

public class VeterinaryService {

    private final PersonRepository personRepository;
    private final PetRepository petRepository;

    public VeterinaryService(PersonRepository personRepository, PetRepository petRepository) {
        this.personRepository = personRepository;
        this.petRepository = petRepository;
    }

    // Registrar persona (Admin, Veterinarian, Seller, Owner)
    public void registrarPersona(Person person) {
        // Validar que no exista la cédula
        Optional<Person> existente = personRepository.buscarPorCedula(person.getCedula());
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Ya existe una persona con la cédula: " + person.getCedula());
        }
        personRepository.guardar(person);
    }

    // Registrar mascota (solo si el dueño existe)
    public void registrarMascota(Pet pet) {
        Optional<Person> dueno = personRepository.buscarPorCedula(pet.getCedulaDueno());
        if (dueno.isEmpty() || !(dueno.get() instanceof Owner)) {
            throw new IllegalArgumentException("El dueño no existe o no es válido");
        }
        petRepository.guardar(pet);
    }

    // Consultar mascotas por dueño
    public List<Pet> listarMascotasPorDueno(String cedulaDueno) {
        return petRepository.listarPorDueno(cedulaDueno);
    }

    // Consultar todas las personas
    public List<Person> listarPersonas() {
        return personRepository.listarTodos();
    }
}