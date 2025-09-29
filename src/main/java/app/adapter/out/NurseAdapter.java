package app.adapter.out;

import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.port.in.Nurse.SearchMedicalRecordByid;
import app.domain.repository.NurseRepository;
import app.domain.service.NurseService;

@Service
public class NurseAdapter implements NurseRepository {

	@Override
	public void addMedicalRecord(SearchMedicalRecordByid addMedicalRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Patient> searchPatientByid(long id, SearchMedicalRecordByid searchPatientByid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalRecord> searchMedicalRecordByid(long id, SearchMedicalRecordByid searchMedicalRecordByid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMedicalRecord(NurseService addMedicalRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Patient> searchPatientByid(long id, NurseService searchPatientByid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalRecord> searchMedicalRecordByid(long id, NurseService searchMedicalRecordByid) {
		// TODO Auto-generated method stub
		return null;
	}

}
