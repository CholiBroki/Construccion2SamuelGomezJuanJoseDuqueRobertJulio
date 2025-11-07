package app.adapter.out;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.domain.model.Appointment;
import app.domain.repository.AppointmentRepository;
import app.domain.valueobject.Id;

@Service					
public class AppointmentAdapter implements AppointmentRepository {

	@Override
	public void cancelApoinment(Id appointmentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Appointment> getAppointmentsByPatient(Id patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reschedule(Id appointmentId, Appointment updatedAppointment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void schedule(Appointment appointment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Appointment appointment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Appointment> findById(Id appointmentId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Appointment> findByPatientId(Id patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Id appointmentId) {
		// TODO Auto-generated method stub
		
	}

}