package app.domain.repository;


import app.domain.model.Billing;
import app.domain.valueobject.Id;

import java.util.Optional;
import java.util.List;

public interface BillingRepository {
    Billing save(Billing billing);
    void delete(Id id);
    Optional<Billing> findById(Id id);
    List<Billing> findByPatientId(Id patientId);
}