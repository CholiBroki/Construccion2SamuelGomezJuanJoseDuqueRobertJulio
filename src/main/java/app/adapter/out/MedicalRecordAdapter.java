package app.adapter.out;

import java.util.List;


import org.springframework.stereotype.Service;

import app.domain.model.Doctor;
import app.domain.model.MedicalRecord;
import app.domain.repository.MedicalRecordRepository;
import app.domain.service.DoctorService;
import app.domain.valueobject.Id;

@Service
public class MedicalRecordAdapter implements MedicalRecordRepository {

	@Override
	public List<MedicalRecord> SearchMedicalRecord(long id, MedicalRecord searchMedicalRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteMedicalRecord(long id, MedicalRecord DeleteMedicalRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(MedicalRecord medicalRecord, Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(DoctorService modifyMedicalRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <SearchMedicalRecordByid> void save(SearchMedicalRecordByid addMedicalRecord) {
		// TODO Auto-generated method stub
		
	}

	public void save(Id createmedicalRecord) {
		// TODO Auto-generated method stub
		
	}

}