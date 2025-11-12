package app.domain.repository;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.valueobject.Id;
import java.util.List;

public interface DoctorRepository {
    
    void modifyMedicalRecord(long id, MedicalRecord modifyMedicalRecord);
    
    void deleteMedicalRecord(long id, MedicalRecord deleteMedicalRecord);
    
    List<Patient> findAllPatient();
    
    List<Patient> searchPatientById(Id patientId);
    
    List<MedicalRecord> searchMedicalRecord(Id searchMedicalRecord);
    
    void deletePatient(Id deletePatient);
}