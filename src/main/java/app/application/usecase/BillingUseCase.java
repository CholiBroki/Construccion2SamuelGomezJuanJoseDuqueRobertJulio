package app.application.usecase;

import java.util.List;

import app.domain.model.Billing;
import app.domain.repository.BillingRepository;
import app.domain.valueobject.Id;

public class BillingUseCase {
	
	private BillingRepository billingRepository;
	
    public List<Billing> GetBillingsByPatientUseCase(Id billingpatientId) {
		return (List<Billing>)billingpatientId;
	}
    public void register(Billing billing) {
	}

}