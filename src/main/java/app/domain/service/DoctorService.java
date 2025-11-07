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
	public void deleteMedicalRecord(Id deleteMedicalRecord) {
		MedicalRecordRepository medicalRecordRepository = null;
	}

}
