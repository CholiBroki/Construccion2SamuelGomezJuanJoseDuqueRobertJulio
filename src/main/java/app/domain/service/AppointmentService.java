package app.domain.service;

import app.domain.model.Appointment;
import app.domain.repository.AppointmentRepository;
import app.domain.valueobject.Id;

import java.util.Optional;


public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void scheduleAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public void rescheduleAppointment(Id appointmentId, Appointment updatedAppointment) {
        Optional<Appointment> existing = appointmentRepository.findById(appointmentId);
        if (existing.isPresent()) {
            Appointment appointment = existing.get();
            appointment.reschedule(updatedAppointment.getDateTime());
            appointment.updateDoctor(updatedAppointment.getDoctor());
            appointment.updateNotes(updatedAppointment.getNotes());
            appointmentRepository.save(appointment);
        } else {
            throw new IllegalArgumentException("Cita no encontrada con id: " + appointmentId.getValue());
        }
    }

}