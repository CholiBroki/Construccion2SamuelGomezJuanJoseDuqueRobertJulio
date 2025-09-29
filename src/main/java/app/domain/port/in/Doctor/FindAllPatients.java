package app.domain.port.in.Doctor;

import java.util.List;

import app.domain.model.Patient;
import app.domain.repository.DoctorRepository;
import app.domain.service.DoctorService;

public class FindAllPatients {
	private final DoctorRepository doctorRepository;
	
	public FindAllPatients(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	public List<Patient>findAllPatient(DoctorService findPatients){
		return (List<Patient>) findPatients;
	}
}
