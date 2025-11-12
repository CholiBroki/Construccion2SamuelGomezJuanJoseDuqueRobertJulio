package app.adapter.out;

import app.domain.model.Appointment;
import app.domain.valueobject.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentAdapter {

    // Implementación temporal en memoria
    // TODO: Crear AppointmentJpaRepository cuando lo necesites

    public void cancelAppointment(Id appointmentId) {
        // Implementación temporal
    }

    public List<Appointment> getAppointmentsByPatient(Id patientId) {
        return new ArrayList<>();
    }

    public void reschedule(Id appointmentId, Appointment updatedAppointment) {
        // Implementación temporal
    }

    public void schedule(Appointment appointment) {
        // Implementación temporal
    }

    public void save(Appointment appointment) {
        // Implementación temporal
    }

    public Optional<Appointment> findById(Id appointmentId) {
        return Optional.empty();
    }

    public List<Appointment> findByPatientId(Id patientId) {
        return new ArrayList<>();
    }

    public void delete(Id appointmentId) {
        // Implementación temporal
    }
}