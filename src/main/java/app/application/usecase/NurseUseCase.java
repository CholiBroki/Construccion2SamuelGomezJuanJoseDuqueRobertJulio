package app.application.usecase;

import java.util.List;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.repository.MedicalRecordRepository;
import app.domain.repository.NurseRepository;
import app.domain.valueobject.Id;

public class NurseUseCase {
	
	private NurseRepository nurseRepository;
	
	public void addMedicalRecord(Id addMedicalRecord) {
		Id medicalRecordRepository = addMedicalRecord;
	}
	public List<MedicalRecord> searchMedicalRecordByid(Id searchMedicalRecordByid){
		return (List<MedicalRecord>) searchMedicalRecordByid;
	}
	public List<Patient> searchPatientByid(Id searchPatientByid){
		return (List<Patient>) searchPatientByid;
	}
	

}