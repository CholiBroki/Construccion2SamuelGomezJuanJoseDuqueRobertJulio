package app.domain.port.in.appointment;

import app.domain.model.Appointment;
import app.domain.repository.AppointmentRepository;

public class ScheduleAppointmentUseCase {
	
	 private final AppointmentRepository appointmentRepository;
	public ScheduleAppointmentUseCase(AppointmentRepository appointmentRepository) {
	        this.appointmentRepository = appointmentRepository;
	 }
    public void schedule(Appointment appointment) {
    	
    }
}