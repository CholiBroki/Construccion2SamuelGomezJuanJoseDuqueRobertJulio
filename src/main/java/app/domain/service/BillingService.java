package app.domain.service;

import app.domain.model.Billing;
import app.domain.repository.BillingRepository;
import app.domain.valueobject.Id;

import java.util.List;
import java.util.Optional;

public class BillingService {
    private final BillingRepository billingRepository;

    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public void registerPayment(Billing billing) {
        billingRepository.save(billing);
    }

    public void updatePayment(Id billingId, Billing updatedBilling) {
        Optional<Billing> existing = billingRepository.findById(billingId);
        if (existing.isPresent()) {
            Billing billing = existing.get();
            billing.updateAmount(updatedBilling.getAmount());
            billing.updateDate(updatedBilling.getDate());
            billing.updateInsurance(updatedBilling.getInsurance());
            billingRepository.save(billing);
        } else {
            throw new IllegalArgumentException("Pago no encontrado con id: " + billingId.getValue());
        }
    }

    public void deletePayment(Id billingId) {
        billingRepository.delete(billingId);
    }

    public List<Billing> getPaymentsByPatient(Id patientId) {
        return billingRepository.findByPatientId(patientId);
    }
}