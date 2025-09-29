package app.domain.model;

import app.domain.valueobject.Id;
import java.time.LocalDateTime;

public class Appointment {
    private final Id id;
    private final Id patientId;
    private LocalDateTime dateTime;
    private String doctor;
    private String notes;

    public Appointment(Id id, Id patientId, LocalDateTime dateTime, String doctor, String notes) {
        this.id = id;
        this.patientId = patientId;
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.notes = notes;
    }

    public Id getId() { return id; }
    public Id getPatientId() { return patientId; }
    public LocalDateTime getDateTime() { return dateTime; }
    public String getDoctor() { return doctor; }
    public String getNotes() { return notes; }

    // Métodos de negocio
    public void reschedule(LocalDateTime newDateTime) {
        if (newDateTime == null || newDateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Fecha inválida para la cita");
        }
        this.dateTime = newDateTime;
    }

    public void updateDoctor(String newDoctor) {
        if (newDoctor == null || newDoctor.isBlank()) {
            throw new IllegalArgumentException("Nombre del doctor inválido");
        }
        this.doctor = newDoctor;
    }

    public void updateNotes(String newNotes) {
        this.notes = newNotes;
    }
}


