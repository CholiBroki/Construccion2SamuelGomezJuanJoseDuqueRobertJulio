package app.domain.repository;

import app.domain.model.Medication;
import app.domain.valueobject.Id;
import java.util.Optional;
import java.util.List;

public interface MedicationRepository {
    void save(Medication medication);
    Optional<Medication> findById(Id id);
    void delete(Id id);
    List<Medication> findAll();
}