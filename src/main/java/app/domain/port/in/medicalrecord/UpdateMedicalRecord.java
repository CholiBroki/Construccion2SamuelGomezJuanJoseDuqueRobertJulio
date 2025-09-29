package app.domain.port.in.medicalrecord;

import app.domain.model.MedicalRecord;
import app.domain.repository.MedicalRecordRepository;

public class UpdateMedicalRecord {
	private final MedicalRecordRepository medicalRecordRepository;
	
	public UpdateMedicalRecord(MedicalRecordRepository medicalRecordRepository) {
		this.medicalRecordRepository = medicalRecordRepository;
	}
	public void UpdateMedicalRecord(long id, MedicalRecord updateMedicalRecord) {
		MedicalRecord medicalRecord =  updateMedicalRecord;
	
	}
}
