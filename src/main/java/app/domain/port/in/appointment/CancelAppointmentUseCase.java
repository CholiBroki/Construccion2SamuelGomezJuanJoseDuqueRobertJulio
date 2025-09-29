package app.domain.port.in.appointment;

import app.domain.repository.AppointmentRepository;
import app.domain.valueobject.Id;

public class CancelAppointmentUseCase {
	
	 private final AppointmentRepository appointmentRepository;
	 
	public CancelAppointmentUseCase(AppointmentRepository appointmentRepository) {		 
	        this.appointmentRepository = appointmentRepository;
	 }
    public void cancelApoinment(Id appointmentId) {
    	
    }
}

