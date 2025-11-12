package app.adapter.out;

import app.domain.model.Patient;
import app.domain.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientAdapter {

    @Autowired
    private PatientRepository patientRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findByDocumentId(String documentId) {
        return patientRepository.findByDocumentId(documentId);
    }

    public List<Patient> searchByName(String name) {
        return patientRepository.searchByName(name);
    }

    public List<Patient> findByBloodType(String bloodType) {
        return patientRepository.findByBloodType(bloodType);
    }

    public List<Patient> findByGender(String gender) {
        return patientRepository.findByGender(gender);
    }

    public boolean existsByDocumentId(String documentId) {
        return patientRepository.existsByDocumentId(documentId);
    }

    public boolean existsByEmail(String email) {
        return patientRepository.existsByEmail(email);
    }

    public Optional<Patient> findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }
}