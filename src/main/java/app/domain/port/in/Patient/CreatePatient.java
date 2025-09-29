package app.domain.port.in.Patient;

import app.domain.model.Patient;
import app.domain.repository.PatientRepository;

public class CreatePatient {

	private final PatientRepository patientRepository;

	public CreatePatient(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	public void createPatient(Patient patient) {
	}
}
