package app.domain.port.in.Patient;

import app.domain.repository.AppointmentRepository;
import app.domain.repository.PatientRepository;
import app.domain.valueobject.Id;

public class DeletePatient {
	
	   private final PatientRepository patientRepository;

	public DeletePatient(PatientRepository patientRepository) {
	        this.patientRepository = patientRepository;
	    }
	
    public void deletePatient(Id patientId) {
    	
    }
}
