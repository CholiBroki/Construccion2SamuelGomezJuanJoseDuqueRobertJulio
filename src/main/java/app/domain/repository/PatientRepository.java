package app.domain.repository;

import app.domain.model.Patient;
import app.domain.valueobject.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    // Buscar por documento de identidad
    Optional<Patient> findByDocumentId(String documentId);
    
    // Buscar por email
    Optional<Patient> findByEmail(String email);
    
    // Buscar por nombre (parcial)
    @Query("SELECT p FROM Patient p WHERE " +
           "LOWER(p.firstName) LIKE LOWER(CONCAT('%', :name, '%')) OR " +
           "LOWER(p.lastName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Patient> searchByName(@Param("name") String name);
    
    // Buscar por tipo de sangre
    List<Patient> findByBloodType(String bloodType);
    
    // Buscar por género
    List<Patient> findByGender(String gender);
    
    // Verificar si existe por documento
    boolean existsByDocumentId(String documentId);
    
    // Verificar si existe por email
    boolean existsByEmail(String email);

	void createPatient(Patient patient);

	void deletePatient(Id patientId);

	List<Patient> findPatientById(Id patientId);

	void updatePatient(Id patientId, Patient updatedPatient);

	void delete(Id patientId);

	Optional<Patient> findById(Id patientId);
}