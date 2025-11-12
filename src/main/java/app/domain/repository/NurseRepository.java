package app.domain.repository;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.valueobject.Id;
import java.util.List;

public interface NurseRepository {
    
    void addMedicalRecord(Id addMedicalRecord);
    
    List<MedicalRecord> searchMedicalRecordByid(Id searchMedicalRecordByid);
    
    List<Patient> searchPatientByid(Id searchPatientByid);
}