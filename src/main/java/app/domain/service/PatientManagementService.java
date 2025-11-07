package app.domain.service;

import app.domain.model.Patient;
import app.domain.repository.PatientRepository;
import app.domain.valueobject.Id;

import java.util.Optional;

public class PatientManagementService {

    private final PatientRepository patientRepository;

    public PatientManagementService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Crear paciente
    public void createPatient(Patient patient) {
        patientRepository.save(patient);
    }

    // Eliminar paciente
    public void deletePatient(Id patientId) {
        patientRepository.delete(patientId);
    }

    // Encontrar paciente por Id
    public Optional<Patient> findPatientById(Id patientId) {
        return patientRepository.findById(patientId);
    }

    // Actualizar nombre completo
    public void updateName(Id patientId, String newFirstName, String newLastName) {
        Patient patient = getPatientOrThrow(patientId);
        patient.changeName(newFirstName, newLastName);
        patientRepository.save(patient);
    }

    // Actualizar dirección
    public void updateAddress(Id patientId, String newAddress) {
        Patient patient = getPatientOrThrow(patientId);
        patient.changeAddress(newAddress);
        patientRepository.save(patient);
    }

    // Actualizar email
    public void updateEmail(Id patientId, app.domain.valueobject.Email newEmail) {
        Patient patient = getPatientOrThrow(patientId);
        patient.changeEmail(newEmail);
        patientRepository.save(patient);
    }

    // Actualizar teléfono
    public void updatePhone(Id patientId, app.domain.valueobject.Phone newPhone) {
        Patient patient = getPatientOrThrow(patientId);
        patient.changePhone(newPhone);
        patientRepository.save(patient);
    }

    // Actualizar registro médico
    public void updateMedicalRecord(Id patientId, String newRecord) {
        Patient patient = getPatientOrThrow(patientId);
        patient.updateMedicalRecord(newRecord);
        patientRepository.save(patient);
    }

    // Actualizar contacto de emergencia
    public void updateEmergencyContact(Id patientId, String firstName, String lastName, String relation, app.domain.valueobject.Phone phone) {
        Patient patient = getPatientOrThrow(patientId);
        patient.changeEmergencyContact(firstName, lastName, relation, phone);
        patientRepository.save(patient);
    }


    private Patient getPatientOrThrow(Id patientId) {
        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        if (patientOpt.isPresent()) {
            return patientOpt.get();
        } else {
            throw new IllegalArgumentException("Paciente no encontrado: " + patientId.getValue());
        }
    }
}