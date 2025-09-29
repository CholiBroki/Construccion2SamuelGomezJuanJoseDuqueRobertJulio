package app.domain.port.in.Doctor;

import java.util.List;

import app.domain.model.Patient;
import app.domain.repository.DoctorRepository;
import app.domain.service.DoctorService;

public class SearchPatientById {
	private final DoctorRepository doctorRepository;

	public SearchPatientById(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	
	public List<Patient>searchPatientById(DoctorService searchPatient){
		return (List<Patient>) searchPatient;
	}

}
