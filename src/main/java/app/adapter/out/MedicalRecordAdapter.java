package app.adapter.out;

import app.domain.model.MedicalRecord;
import app.domain.valueobject.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalRecordAdapter {

    // Implementación temporal en memoria
    // TODO: Crear MedicalRecordJpaRepository cuando lo necesites

    public List<MedicalRecord> searchMedicalRecord(long id, MedicalRecord searchMedicalRecord) {
        return new ArrayList<>();
    }

    public void deleteMedicalRecord(long id, MedicalRecord deleteMedicalRecord) {
        // Implementación temporal
    }

    public void save(MedicalRecord medicalRecord) {
        // Implementación temporal
    }

    public void createMedicalRecord(Id createmedicalRecord) {
        // Implementación temporal
    }
}