package app.domain.service;

import app.adapter.out.DoctorAdapter;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.valueobject.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    
    @Autowired
    private DoctorAdapter doctorAdapter;

    public void modifyMedicalRecord(long id, MedicalRecord medicalRecord) {
        doctorAdapter.modifyMedicalRecord(id, medicalRecord);
    }

    public void deleteMedicalRecord(long id, MedicalRecord medicalRecord) {
        doctorAdapter.deleteMedicalRecord(id, medicalRecord);
    }

    public List<Patient> findAllPatient() {
        return doctorAdapter.findAllPatient();
    }

    public List<Patient> searchPatientById(Id patientId) {
        return doctorAdapter.searchPatientById(patientId);
    }

    public List<MedicalRecord> searchMedicalRecord(Id searchMedicalRecord) {
        return doctorAdapter.searchMedicalRecord(searchMedicalRecord);
    }

    public void deletePatient(Id deletePatient) {
        doctorAdapter.deletePatient(deletePatient);
    }
}