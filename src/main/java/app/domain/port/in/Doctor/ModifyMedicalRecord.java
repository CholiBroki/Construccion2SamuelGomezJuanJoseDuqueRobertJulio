package app.domain.port.in.Doctor;

import app.domain.repository.DoctorRepository;
import app.domain.repository.MedicalRecordRepository;
import app.domain.valueobject.Id;

public class ModifyMedicalRecord {
	private final DoctorRepository doctorRepository;

	public ModifyMedicalRecord(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	public void modifyMedicalRecord(Id modifyMedicalRecord) {
		MedicalRecordRepository medicalRecordRepository = (MedicalRecordRepository) modifyMedicalRecord;
	}


}
