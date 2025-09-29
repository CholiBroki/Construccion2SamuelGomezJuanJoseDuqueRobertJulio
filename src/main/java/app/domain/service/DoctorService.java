package app.domain.service;

import java.util.List;


import app.domain.model.Patient;
import app.domain.repository.DoctorRepository;
import app.domain.repository.MedicalRecordRepository;
import app.domain.valueobject.Id;

public class DoctorService {
	private final DoctorRepository doctorRepository;

	public DoctorService(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	public List<Patient> findAllPatient(DoctorService findPatients) {
		return (List<Patient>) findPatients;
	}

	public List<Patient> searchPatientById(DoctorService searchPatient) {
		return (List<Patient>) searchPatient;
	}

	public void modifyMedicalRecord(Id  modifiedRecord) {
		DoctorService modifyMedicalRecord = null;
		MedicalRecordRepository.save(modifyMedicalRecord);
	}

	public void deleteMedicalRecord(Id talcual) {
		// Usa medicalRecordRepository directamente
		MedicalRecordRepository.deleteById(talcual);
	}

}
