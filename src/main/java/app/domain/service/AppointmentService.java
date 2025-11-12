package app.domain.service;

import app.adapter.out.AppointmentAdapter;
import app.domain.model.Appointment;
import app.domain.valueobject.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {
    
    @Autowired
    private AppointmentAdapter appointmentAdapter;

    public void scheduleAppointment(Appointment appointment) {
        appointmentAdapter.save(appointment);
    }

    public void rescheduleAppointment(Id appointmentId, Appointment updatedAppointment) {
        Optional<Appointment> existing = appointmentAdapter.findById(appointmentId);
        if (existing.isPresent()) {
            Appointment appointment = existing.get();
            appointment.reschedule(updatedAppointment.getDateTime());
            appointment.updateDoctor(updatedAppointment.getDoctor());
            appointment.updateNotes(updatedAppointment.getNotes());
            appointmentAdapter.save(appointment);
        } else {
            throw new IllegalArgumentException("Cita no encontrada con id: " + appointmentId.getValue());
        }
    }
}