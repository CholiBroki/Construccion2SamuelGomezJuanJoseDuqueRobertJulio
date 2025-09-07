package app.domain.repository;

import java.util.List;

import app.domain.model.Patient;
import app.domain.services.DoctorService;

public interface DoctorRepository {
	public void modifyMedicalRecord(long id, DoctorService modifyMedicalRecord);
	public void deleteMedicalRecord(long id, DoctorService deleteMedicalRecord);
	public List<Patient>findAllPatient(DoctorService findPatients);
	public List<Patient>searchPatientById(DoctorService searchPatient);
	void modifyMedicalRecord(long id, app.domain.service.DoctorService modifyMedicalRecord);
	void deleteMedicalRecord(long id, app.domain.service.DoctorService deleteMedicalRecord);
	List<Patient> findAllPatient(app.domain.service.DoctorService findPatients);
	List<Patient> searchPatientById(app.domain.service.DoctorService searchPatient);
}