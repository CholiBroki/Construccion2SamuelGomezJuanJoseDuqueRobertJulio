package app.adapter.out;

import java.util.List;


import org.springframework.stereotype.Service;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.repository.NurseRepository;
import app.domain.valueobject.Id;

@Service
public class NurseAdapter implements NurseRepository {


	@Override
	public void addMedicalRecord(Id addMedicalRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MedicalRecord> searchMedicalRecordByid(Id searchMedicalRecordByid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> searchPatientByid(Id searchPatientByid) {
		// TODO Auto-generated method stub
		return null;
	}

}
