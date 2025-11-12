package app.adapter.out;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.repository.PatientRepository;
import app.domain.valueobject.Id;

@Service
public abstract class PatientAdapter implements  PatientRepository{

	@Override
	public void createPatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePatient(Id patientId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Patient> findPatientById(Id patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePatient(Id patientId, Patient updatedPatient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Patient> S save(S patient) {
		return patient;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Id patientId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Patient> findById(Id patientId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



}