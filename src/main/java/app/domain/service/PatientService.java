package app.domain.service;

import app.domain.model.Patient;
import app.domain.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Crear paciente
    public Patient createPatient(Patient patient) {
        System.out.println("👤 [PatientService] Creando paciente: " + patient.getFullName());
        
        // Validar que no exista el documento
        if (patientRepository.existsByDocumentId(patient.getDocumentId())) {
            throw new IllegalArgumentException("Ya existe un paciente con el documento: " + patient.getDocumentId());
        }
        
        // Validar email si existe
        if (patient.getEmail() != null && !patient.getEmail().isEmpty()) {
            if (patientRepository.existsByEmail(patient.getEmail())) {
                throw new IllegalArgumentException("Ya existe un paciente con el email: " + patient.getEmail());
            }
        }
        
        Patient saved = patientRepository.save(patient);
        System.out.println("✅ [PatientService] Paciente creado con ID: " + saved.getId());
        return saved;
    }

    // Obtener paciente por ID
    public Optional<Patient> getPatientById(Long id) {
        System.out.println("🔍 [PatientService] Buscando paciente ID: " + id);
        return patientRepository.findById(id);
    }

    // Obtener paciente por documento
    public Optional<Patient> getPatientByDocument(String documentId) {
        System.out.println("🔍 [PatientService] Buscando paciente por documento: " + documentId);
        return patientRepository.findByDocumentId(documentId);
    }

    // Obtener paciente por email
    public Optional<Patient> getPatientByEmail(String email) {
        System.out.println("🔍 [PatientService] Buscando paciente por email: " + email);
        return patientRepository.findByEmail(email);
    }

    // Listar todos los pacientes
    public List<Patient> getAllPatients() {
        System.out.println("📋 [PatientService] Listando todos los pacientes");
        return patientRepository.findAll();
    }

    // Buscar pacientes por nombre
    public List<Patient> searchPatientsByName(String name) {
        System.out.println("🔍 [PatientService] Buscando pacientes por nombre: " + name);
        return patientRepository.searchByName(name);
    }

    // Buscar por tipo de sangre
    public List<Patient> getPatientsByBloodType(String bloodType) {
        System.out.println("🔍 [PatientService] Buscando pacientes con tipo de sangre: " + bloodType);
        return patientRepository.findByBloodType(bloodType);
    }

    // Buscar por género
    public List<Patient> getPatientsByGender(String gender) {
        System.out.println("🔍 [PatientService] Buscando pacientes por género: " + gender);
        return patientRepository.findByGender(gender);
    }

    // Actualizar paciente
    public Patient updatePatient(Long id, Patient updatedPatient) {
        System.out.println("✏️ [PatientService] Actualizando paciente ID: " + id);
        
        Optional<Patient> existing = patientRepository.findById(id);
        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Paciente no encontrado con ID: " + id);
        }
        
        Patient patient = existing.get();
        
        // Actualizar campos
        if (updatedPatient.getFirstName() != null) {
            patient.setFirstName(updatedPatient.getFirstName());
        }
        if (updatedPatient.getLastName() != null) {
            patient.setLastName(updatedPatient.getLastName());
        }
        if (updatedPatient.getAddress() != null) {
            patient.setAddress(updatedPatient.getAddress());
        }
        if (updatedPatient.getPhone() != null) {
            patient.setPhone(updatedPatient.getPhone());
        }
        if (updatedPatient.getEmail() != null) {
            // Validar que el email no esté en uso por otro paciente
            Optional<Patient> existingEmail = patientRepository.findByEmail(updatedPatient.getEmail());
            if (existingEmail.isPresent() && !existingEmail.get().getId().equals(id)) {
                throw new IllegalArgumentException("El email ya está en uso por otro paciente");
            }
            patient.setEmail(updatedPatient.getEmail());
        }
        if (updatedPatient.getBloodType() != null) {
            patient.setBloodType(updatedPatient.getBloodType());
        }
        if (updatedPatient.getAllergies() != null) {
            patient.setAllergies(updatedPatient.getAllergies());
        }
        if (updatedPatient.getMedicalHistory() != null) {
            patient.setMedicalHistory(updatedPatient.getMedicalHistory());
        }
        if (updatedPatient.getEmergencyContactName() != null) {
            patient.setEmergencyContactName(updatedPatient.getEmergencyContactName());
        }
        if (updatedPatient.getEmergencyContactPhone() != null) {
            patient.setEmergencyContactPhone(updatedPatient.getEmergencyContactPhone());
        }
        if (updatedPatient.getEmergencyContactRelation() != null) {
            patient.setEmergencyContactRelation(updatedPatient.getEmergencyContactRelation());
        }
        
        Patient saved = patientRepository.save(patient);
        System.out.println("✅ [PatientService] Paciente actualizado: " + saved.getFullName());
        return saved;
    }

    // Actualizar historial médico
    public Patient updateMedicalHistory(Long id, String medicalHistory) {
        System.out.println("📋 [PatientService] Actualizando historial médico del paciente ID: " + id);
        
        Optional<Patient> existing = patientRepository.findById(id);
        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Paciente no encontrado con ID: " + id);
        }
        
        Patient patient = existing.get();
        patient.setMedicalHistory(medicalHistory);
        
        Patient saved = patientRepository.save(patient);
        System.out.println("✅ [PatientService] Historial médico actualizado");
        return saved;
    }

    // Actualizar alergias
    public Patient updateAllergies(Long id, String allergies) {
        System.out.println("⚠️ [PatientService] Actualizando alergias del paciente ID: " + id);
        
        Optional<Patient> existing = patientRepository.findById(id);
        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Paciente no encontrado con ID: " + id);
        }
        
        Patient patient = existing.get();
        patient.setAllergies(allergies);
        
        Patient saved = patientRepository.save(patient);
        System.out.println("✅ [PatientService] Alergias actualizadas");
        return saved;
    }

    // Eliminar paciente
    public void deletePatient(Long id) {
        System.out.println("🗑️ [PatientService] Eliminando paciente ID: " + id);
        
        if (!patientRepository.existsById(id)) {
            throw new IllegalArgumentException("Paciente no encontrado con ID: " + id);
        }
        
        patientRepository.deleteById(id);
        System.out.println("✅ [PatientService] Paciente eliminado");
    }

    // Obtener estadísticas
    public long getTotalPatients() {
        return patientRepository.count();
    }
}