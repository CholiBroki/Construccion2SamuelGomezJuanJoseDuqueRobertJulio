package app.domain.repository;

import app.domain.model.Patient;
import app.domain.service.DoctorService;
import app.domain.valueobject.Id;
import java.util.Optional;
import java.util.List;

public interface PatientRepository {
    public void save(Patient patient);
    void delete(Id id);
    Optional<Patient> findById(Id id);
    List<Patient> findAll();
	public static void save(DoctorService createpatient) {}
	void updatePatient(Id patientId, Patient updatedPatient);
	List<Patient> findPatientById(Id patientId);
	void deletePatient(Id patientId);
	void createPatient(Patient patient);

}