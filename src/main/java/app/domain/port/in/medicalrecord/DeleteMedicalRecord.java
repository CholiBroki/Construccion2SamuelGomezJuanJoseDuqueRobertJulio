package app.domain.port.in.medicalrecord;

import java.util.List;

import app.domain.model.MedicalRecord;
import app.domain.repository.MedicalRecordRepository;

public class DeleteMedicalRecord {
	
	private MedicalRecordRepository medicalRecordRepository;
	
	public void MecicalRecordService(MedicalRecordRepository medicalRecordRepository) {
		this.medicalRecordRepository = medicalRecordRepository;
	}
	public void DeleteMedicalRecord(long id, MedicalRecord DeleteMedicalRecord) {
		MedicalRecord medicalRecord = null;
	}

}
