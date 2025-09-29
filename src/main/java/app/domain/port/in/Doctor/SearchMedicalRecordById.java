package app.domain.port.in.Doctor;

import java.util.List;

import app.domain.model.MedicalRecord;
import app.domain.repository.DoctorRepository;
import app.domain.valueobject.Id;

public class SearchMedicalRecordById {
	
	private final DoctorRepository doctorRepository;

	public SearchMedicalRecordById(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	public List<MedicalRecord>searchMedicalRecord(Id searchMedicalRecord){
		return (List<MedicalRecord>) searchMedicalRecord;
	}


}