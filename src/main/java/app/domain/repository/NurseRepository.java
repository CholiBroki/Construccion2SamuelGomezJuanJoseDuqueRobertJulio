package app.domain.repository;

import java.util.List;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.port.in.Nurse.SearchMedicalRecordByid;
import app.domain.service.NurseService;

public interface NurseRepository {
	
	public void addMedicalRecord(NurseService addMedicalRecord);
	public List<Patient> searchPatientByid(long id, NurseService searchPatientByid);
	public List<MedicalRecord> searchMedicalRecordByid(long id, NurseService searchMedicalRecordByid);
	List<Patient> searchPatientByid(long id, SearchMedicalRecordByid searchPatientByid);
	void addMedicalRecord(SearchMedicalRecordByid addMedicalRecord);
	List<MedicalRecord> searchMedicalRecordByid(long id, SearchMedicalRecordByid searchMedicalRecordByid);
}