package app.domain.repository;

import app.domain.model.Appointment;
import app.domain.valueobject.Id;

import java.util.Optional;
import java.util.List;

public interface AppointmentRepository {
	
	 public void cancelApoinment(Id appointmentId);
	 public List<Appointment> getAppointmentsByPatient(Id patientId);
	 public void reschedule(Id appointmentId, Appointment updatedAppointment);
	 public void schedule(Appointment appointment);
	public void save(Appointment appointment);
	public Optional<Appointment> findById(Id appointmentId);
	public List<Appointment> findByPatientId(Id patientId);
	public void delete(Id appointmentId);
}