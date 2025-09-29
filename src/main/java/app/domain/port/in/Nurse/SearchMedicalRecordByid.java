package app.domain.port.in.Nurse;

import java.util.List;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.repository.MedicalRecordRepository;
import app.domain.repository.NurseRepository;

public class SearchMedicalRecordByid {
	private final NurseRepository nurseRepository;
	
	public SearchMedicalRecordByid(NurseRepository nurseRepository) {
		this.nurseRepository = nurseRepository;
	}

	public List<MedicalRecord> searchMedicalRecordByid(long id, SearchMedicalRecordByid searchMedicalRecordByid){
		return (List<MedicalRecord>) searchMedicalRecordByid;
	}
	

}
