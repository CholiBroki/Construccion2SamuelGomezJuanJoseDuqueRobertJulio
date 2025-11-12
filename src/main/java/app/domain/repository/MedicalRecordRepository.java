package app.domain.repository;

import app.domain.model.MedicalRecord;
import app.domain.valueobject.Id;
import java.util.List;

public interface MedicalRecordRepository {
    
    List<MedicalRecord> searchMedicalRecord(long id, MedicalRecord searchMedicalRecord);
    
    void deleteMedicalRecord(long id, MedicalRecord deleteMedicalRecord);
    
    void save(MedicalRecord medicalRecord);
    
    void createMedicalRecord(Id createmedicalRecord);
}