package app.domain.port.in.appointment;

import java.util.List;

import app.domain.model.Appointment;
import app.domain.repository.AppointmentRepository;
import app.domain.valueobject.Id;

public class GetAppointmentsByPatientUseCase {
	
	private final AppointmentRepository appointmentRepository;
	
	 public GetAppointmentsByPatientUseCase(AppointmentRepository appointmentRepository) {
	        this.appointmentRepository = appointmentRepository;
	 }
	    public List<Appointment> getAppointmentsByPatient(Id patientId) {
	        return appointmentRepository.findByPatientId(patientId);
	    }
}
