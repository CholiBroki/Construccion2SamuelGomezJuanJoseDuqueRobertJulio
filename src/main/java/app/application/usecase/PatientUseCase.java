package app.application.usecase;

import java.util.List;

import app.domain.model.Patient;
import app.domain.repository.PatientRepository;
import app.domain.valueobject.Id;

public class PatientUseCase {
	
	private PatientRepository patientRepository;
	
	public Patient createPatient(Patient patient) {
		return patient;
		
	}
    public void deletePatient(Id patientId) {
    	
    }
    public List<Patient> updatePatient(Id patientId, Patient updatedPatient) {
		return null;
	}
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}
	public Patient getPatientById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	public Patient updatePatient(Long id, Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}
	public void deletePatient(Long id) {
		// TODO Auto-generated method stub
		
	}

}