package app.adapter.out;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.valueobject.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorAdapter {

    // Implementación temporal en memoria
    // TODO: Crear DoctorJpaRepository cuando lo necesites

    public void modifyMedicalRecord(long id, MedicalRecord modifyMedicalRecord) {
        // Implementación temporal
    }

    public void deleteMedicalRecord(long id, MedicalRecord deleteMedicalRecord) {
        // Implementación temporal
    }

    public List<Patient> findAllPatient() {
        return new ArrayList<>();
    }

    public List<Patient> searchPatientById(Id patientId) {
        return new ArrayList<>();
    }

    public List<MedicalRecord> searchMedicalRecord(Id searchMedicalRecord) {
        return new ArrayList<>();
    }

    public void deletePatient(Id deletePatient) {
        // Implementación temporal
    }
}