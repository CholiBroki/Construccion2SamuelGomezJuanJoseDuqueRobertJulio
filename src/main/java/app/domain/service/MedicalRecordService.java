package app.domain.service;

import app.domain.model.MedicalRecord;
import app.domain.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecord createMedicalRecord(MedicalRecord record) {
        System.out.println("📋 Creando historial médico");
        return medicalRecordRepository.save(record);
    }

    public Optional<MedicalRecord> getMedicalRecordById(Long id) {
        return medicalRecordRepository.findById(id);
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }

    public List<MedicalRecord> getMedicalRecordsByPatient(Long patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }

    public List<MedicalRecord> getMedicalRecordsByDoctor(Long doctorId) {
        return medicalRecordRepository.findByDoctorId(doctorId);
    }

    public MedicalRecord updateMedicalRecord(Long id, MedicalRecord updated) {
        Optional<MedicalRecord> existing = medicalRecordRepository.findById(id);
        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Historial no encontrado");
        }
        
        MedicalRecord record = existing.get();
        if (updated.getDiagnosis() != null) record.setDiagnosis(updated.getDiagnosis());
        if (updated.getTreatment() != null) record.setTreatment(updated.getTreatment());
        if (updated.getNotes() != null) record.setNotes(updated.getNotes());
        if (updated.getSymptoms() != null) record.setSymptoms(updated.getSymptoms());
        if (updated.getPrescriptions() != null) record.setPrescriptions(updated.getPrescriptions());
        
        return medicalRecordRepository.save(record);
    }

    public void deleteMedicalRecord(Long id) {
        medicalRecordRepository.deleteById(id);
    }
}