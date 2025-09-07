package app.application.port.in.Patient;

import app.domain.model.Patient;

public interface CreatePatientUseCase {
    void createPatient(Patient patient);
}