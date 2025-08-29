package app.domain.repository;

import app.domain.model.Pet;
import java.util.List;
import java.util.Optional;

public interface PetRepository {
    Pet guardar(Pet pet);
    Optional<Pet> buscarPorId(String id);
    List<Pet> listarPorDueno(String cedulaDueno);
}