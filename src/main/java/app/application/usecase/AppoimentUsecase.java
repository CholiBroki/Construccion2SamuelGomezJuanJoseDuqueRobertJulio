package app.application.usecase;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.domain.model.Appointment;
import app.domain.repository.AppointmentRepository;
import app.domain.valueobject.Id;

@Service
public class AppoimentUsecase {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void cancelApoinment(Id appointmentId) {
        appointmentRepository = null;

    }

    public void deleteAppointment(Id appointmentId) {
        appointmentRepository.delete(appointmentId);
    }

    public List<Appointment> getAppointmentsByPatient(Id patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public void reschedule(Id appointmentId, Appointment updatedAppointment) {
        appointmentRepository.save(updatedAppointment);

    }

    public void schedule(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

}