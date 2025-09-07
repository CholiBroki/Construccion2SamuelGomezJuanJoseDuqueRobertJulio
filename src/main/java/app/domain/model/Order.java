package app.domain.model;

import app.domain.valueobject.Id;
import java.time.LocalDate;

public class Order {
    private final Id id;
    private final Id patientId;
    private final String type; // "MEDICAMENTO", "PROCEDIMIENTO", "AYUDA_DIAGNOSTICA"
    private final String name;
    private final double cost;
    private final String details;
    private final LocalDate date;

    public Order(Id id, Id patientId, String type, String name, double cost, String details, LocalDate date) {
        this.id = id;
        this.patientId = patientId;
        this.type = type;
        this.name = name;
        this.cost = cost;
        this.details = details;
        this.date = date;
    }

    public Id getId() { return id; }
    public Id getPatientId() { return patientId; }
    public String getType() { return type; }
    public String getName() { return name; }
    public double getCost() { return cost; }
    public String getDetails() { return details; }
    public LocalDate getDate() { return date; }
}