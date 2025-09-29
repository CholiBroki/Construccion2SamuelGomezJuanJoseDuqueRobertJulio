package app.domain.port.in.billing;

import app.domain.model.Billing;
import app.domain.repository.BillingRepository;
import app.domain.valueobject.Id;
import java.util.List;

public class GetBillingsByPatientUseCase {
	
	   private final BillingRepository billingRepository;

	public GetBillingsByPatientUseCase(BillingRepository billingRepository) {
	        this.billingRepository = billingRepository;
	    }
	
    public List<Billing> GetBillingsByPatientUseCase(Id patientId) {
		return null;
	}
}
