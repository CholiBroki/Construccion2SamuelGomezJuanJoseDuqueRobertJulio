package app.domain.port.in.medicalrecord;

import app.domain.repository.MedicalRecordRepository;
import app.domain.valueobject.Id;

public class CreateMedicalRecord {
	
	private final MedicalRecordRepository medicalRecordRepository;

	public CreateMedicalRecord(MedicalRecordRepository medicalRecordRepository) {
		this.medicalRecordRepository = medicalRecordRepository;
	}
	
}
