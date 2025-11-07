package app.domain.repository;

import java.util.List;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.service.DoctorService;
import app.domain.valueobject.Id;

public interface DoctorRepository {
	public void modifyMedicalRecord1(long id, DoctorService modifyMedicalRecord);
	public void deleteMedicalRecord1(long id, DoctorService deleteMedicalRecord);
	public List<Patient>findAllPatient1(DoctorService findPatients);
	
	void modifyMedicalRecord(long id, app.domain.service.DoctorService modifyMedicalRecord);
	
	List<Patient> findAllPatient(app.domain.service.DoctorService findPatients);
	List<Patient> searchPatientById(app.domain.service.DoctorService searchPatient);
	List<MedicalRecord> searchMedicalRecord(Id searchMedicalRecord);
	void deletePatient(Id deletePatient);
}