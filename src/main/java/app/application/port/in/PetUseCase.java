package app.application.port.in;

import app.domain.model.Pet;
import java.util.List;

public interface PetUseCase {
    void registerPet(Pet pet);
    Pet findById(String id);
    List<Pet> listAllPets();
}