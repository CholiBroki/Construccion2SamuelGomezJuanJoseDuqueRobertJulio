package app.application.port.in.medicalrecord;

import app.domain.model.MedicalRecord;

public interface CreateMedicalRecordUseCase {
    void create(MedicalRecord medicalRecord);
}
