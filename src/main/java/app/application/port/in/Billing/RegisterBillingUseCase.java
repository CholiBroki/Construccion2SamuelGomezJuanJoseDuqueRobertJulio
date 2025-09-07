package app.application.port.in.Billing;

import app.domain.model.Billing;

public interface RegisterBillingUseCase {
    void register(Billing billing);
}