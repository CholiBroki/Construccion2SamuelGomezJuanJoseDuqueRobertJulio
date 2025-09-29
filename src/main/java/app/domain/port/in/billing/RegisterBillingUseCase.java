package app.domain.port.in.billing;

import app.domain.model.Billing;
import app.domain.repository.BillingRepository;

public class RegisterBillingUseCase {
	
	   private final BillingRepository billingRepository;

	public RegisterBillingUseCase(BillingRepository billingRepository) {
	        this.billingRepository = billingRepository;
	    }
	
    public void register(Billing billing) {
	}
}
