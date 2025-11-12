package app.adapter.out;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.valueobject.Id;

@Service
public class NurseAdapter {

    // Implementación temporal en memoria
    // TODO: Crear NurseJpaRepository cuando lo necesites

    public void addMedicalRecord(Id addMedicalRecord) {
        // Implementación temporal
    }

    public List<MedicalRecord> searchMedicalRecordByid(Id searchMedicalRecordByid) {
        return new ArrayList<>();
    }

    public List<Patient> searchPatientByid(Id searchPatientByid) {
        return new ArrayList<>();
    }
}