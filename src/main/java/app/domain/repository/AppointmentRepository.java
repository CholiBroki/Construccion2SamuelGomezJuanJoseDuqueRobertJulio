package app.domain.repository;

import app.domain.model.Appointment;
import app.domain.valueobject.Id;
import java.util.Optional;
import java.util.List;

public interface AppointmentRepository {
    
    void cancelAppointment(Id appointmentId);
    
    List<Appointment> getAppointmentsByPatient(Id patientId);
    
    void reschedule(Id appointmentId, Appointment updatedAppointment);
    
    void schedule(Appointment appointment);
    
    void save(Appointment appointment);
    
    Optional<Appointment> findById(Id appointmentId);
    
    List<Appointment> findByPatientId(Id patientId);
    
    void delete(Id appointmentId);
}