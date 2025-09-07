package app.domain.service;

import java.util.List;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.repository.MedicalRecordRepository;
import app.domain.repository.NurseRepository;

public class NurseService {
	private NurseRepository nurseRepository;
	
	public NurseService(NurseRepository nurseRepository) {
		this.nurseRepository = nurseRepository;
	}
	public void addMedicalRecord(NurseService addMedicalRecord) {
		MedicalRecordRepository.save(addMedicalRecord);
	}
	public List<Patient> searchPatientByid(long id, NurseService searchPatientByid){
		return (List<Patient>) searchPatientByid;
	}
	public List<MedicalRecord> searchMedicalRecordByid(long id, NurseService searchMedicalRecordByid){
		return (List<MedicalRecord>) searchMedicalRecordByid;
	}
	

}