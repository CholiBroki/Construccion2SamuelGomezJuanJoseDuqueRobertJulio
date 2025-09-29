package app.domain.port.in.appointment;

import app.domain.repository.AppointmentRepository;
import app.domain.valueobject.Id;

public class DeleteAppointment {
	
	 private final AppointmentRepository appointmentRepository;
	public DeleteAppointment(AppointmentRepository appointmentRepository) {
	        this.appointmentRepository = appointmentRepository;
	 }
    public void deleteAppointment(Id appointmentId) {
        appointmentRepository.delete(appointmentId);
    }

}
