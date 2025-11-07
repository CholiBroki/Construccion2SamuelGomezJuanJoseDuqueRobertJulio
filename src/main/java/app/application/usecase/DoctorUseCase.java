package app.application.usecase;

import java.util.List;

import app.domain.model.Doctor;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.repository.DoctorRepository;
import app.domain.repository.MedicalRecordRepository;
import app.domain.repository.PatientRepository;
import app.domain.service.DoctorService;
import app.domain.valueobject.Id;

public class DoctorUseCase {
	
	private DoctorRepository doctorRepository;
	
	public void deletePatient(Id deletePatient) {
		PatientRepository patientRepository = null;
	}
	public List<Patient>findAllPatient(DoctorService findPatients){
		return (List<Patient>) findPatients;
	}
	public void modifyMedicalRecord(Id modifyMedicalRecord) {
		MedicalRecordRepository medicalRecordRepository = (MedicalRecordRepository) modifyMedicalRecord;
	}
	public List<MedicalRecord>searchMedicalRecord(Id searchMedicalRecord){
		return (List<MedicalRecord>) searchMedicalRecord;
	}
	public List<Patient>searchPatientById(DoctorService searchPatient){
		return (List<Patient>) searchPatient;
	}
	public void deleteDoctor(Long id) {
		// TODO Auto-generated method stub
		
	}
	public Doctor updateDoctor(Long id, Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}
	public Doctor createDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}
	public Doctor getDoctorById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return null;
	}

}