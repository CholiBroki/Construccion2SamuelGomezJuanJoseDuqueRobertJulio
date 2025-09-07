package app.application.port.in.Patient;

import app.domain.valueobject.Id;

public interface DeletePatientUseCase {
    void deletePatient(Id patientId);
}