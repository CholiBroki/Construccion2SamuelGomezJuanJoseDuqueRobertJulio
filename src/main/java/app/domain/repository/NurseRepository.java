package app.domain.repository;

import java.util.List;


import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.valueobject.Id;

public interface NurseRepository {
	
	public void addMedicalRecord(Id addMedicalRecord);
	public List<MedicalRecord> searchMedicalRecordByid(Id searchMedicalRecordByid);
	public List<Patient> searchPatientByid(Id searchPatientByid);
	
}
