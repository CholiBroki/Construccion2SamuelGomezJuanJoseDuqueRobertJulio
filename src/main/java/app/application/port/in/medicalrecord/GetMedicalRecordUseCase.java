package app.application.port.in.medicalrecord;

import app.domain.model.MedicalRecord;
import java.util.Optional;

public interface GetMedicalRecordUseCase {
    Optional<MedicalRecord> getMedicalRecordById(Long id);
}