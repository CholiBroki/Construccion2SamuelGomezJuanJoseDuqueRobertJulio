package app.application.port.in.Billing;

import app.domain.model.Billing;
import app.domain.valueobject.Id;
import java.util.List;

public interface BillingByPatientUseCase {
    List<Billing> getByPatient(Id patientId);
}
