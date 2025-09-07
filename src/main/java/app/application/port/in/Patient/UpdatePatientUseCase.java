package app.application.port.in.Patient;

import app.domain.model.Patient;
import app.domain.valueobject.Id;

public interface UpdatePatientUseCase {
    void updatePatient(Id patientId, Patient updatedPatient);
}
