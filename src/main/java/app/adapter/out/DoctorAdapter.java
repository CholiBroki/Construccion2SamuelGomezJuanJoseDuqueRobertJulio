package app.adapter.out;

import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.repository.DoctorRepository;
import app.domain.service.DoctorService;
import app.domain.valueobject.Id;

@Service
public class DoctorAdapter implements DoctorRepository{

	@Override
	public void modifyMedicalRecord(long id, DoctorService modifyMedicalRecord) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public List<Patient> findAllPatient(DoctorService findPatients) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> searchPatientById(DoctorService searchPatient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalRecord> searchMedicalRecord(Id searchMedicalRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePatient(Id deletePatient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMedicalRecord1(long id, DoctorService modifyMedicalRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMedicalRecord1(long id, DoctorService deleteMedicalRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Patient> findAllPatient1(DoctorService findPatients) {
		// TODO Auto-generated method stub
		return null;
	}



}
