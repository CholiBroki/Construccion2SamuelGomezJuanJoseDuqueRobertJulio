package app.domain.port.in.Doctor;

import app.domain.repository.DoctorRepository;
import app.domain.repository.PatientRepository;
import app.domain.valueobject.Id;

public class DeletePatient {
	
	private final DoctorRepository doctorRepository;

	public DeletePatient(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	public void deletePatient(Id deletePatient) {
		PatientRepository patientRepository = null;
	}


}
