package app.application.usecase;

import java.util.List;

import app.domain.model.MedicalRecord;
import app.domain.repository.MedicalRecordRepository;
import app.domain.valueobject.Id;

public class MedicalRecordUseCase {
	
	private MedicalRecordRepository medicalRecordRepository;
	
	public void CreateMedicalRecord (Id createmedicalRecord) {
		
	}
	public void DeleteMedicalRecord(long id, MedicalRecord DeleteMedicalRecord) {
		MedicalRecord medicalRecord = null;
	}
	public List<MedicalRecord> SearchMedicalRecord(long id, MedicalRecord searchMedicalRecord) {
		return (List<MedicalRecord>) searchMedicalRecord;
	}
	public void UpdateMedicalRecord(long id, MedicalRecord updateMedicalRecord) {
		MedicalRecord medicalRecord =  updateMedicalRecord;
		
	}

}