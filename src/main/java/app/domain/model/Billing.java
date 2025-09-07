package app.domain.model;

import app.domain.valueobject.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Billing {
    private final Id id;
    private final Id patientId;
    private BigDecimal amount;
    private LocalDate date;
    private String insurance;

    public Billing(Id id, Id patientId, BigDecimal amount, LocalDate date, String insurance) {
        this.id = id;
        this.patientId = patientId;
        this.amount = amount;
        this.date = date;
        this.insurance = insurance;
    }

    public Id getId() { return id; }
    public Id getPatientId() { return patientId; }
    public BigDecimal getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getInsurance() { return insurance; }

    // Métodos de negocio
    public void updateAmount(BigDecimal newAmount) {
        if (newAmount == null || newAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Monto inválido");
        }
        this.amount = newAmount;
    }

    public void updateInsurance(String newInsurance) {
        this.insurance = newInsurance;
    }

    public void updateDate(LocalDate newDate) {
        this.date = newDate;
    }
}