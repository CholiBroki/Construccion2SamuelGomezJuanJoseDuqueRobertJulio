package app.application.usecase;

import app.adapter.out.AppointmentAdapter;
import app.domain.model.Appointment;
import app.domain.valueobject.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppoimentUsecase {

    @Autowired
    private AppointmentAdapter appointmentAdapter;

    public void cancelAppointment(Id appointmentId) {
        appointmentAdapter.cancelAppointment(appointmentId);
    }

    public void deleteAppointment(Id appointmentId) {
        appointmentAdapter.delete(appointmentId);
    }

    public List<Appointment> getAppointmentsByPatient(Id patientId) {
        return appointmentAdapter.findByPatientId(patientId);
    }

    public void reschedule(Id appointmentId, Appointment updatedAppointment) {
        appointmentAdapter.save(updatedAppointment);
    }

    public void schedule(Appointment appointment) {
        appointmentAdapter.save(appointment);
    }
}