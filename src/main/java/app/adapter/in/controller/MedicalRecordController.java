package app.adapter.in.controller;

import app.domain.model.MedicalRecord;
import app.domain.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER')")
    public ResponseEntity<?> createMedicalRecord(@RequestBody MedicalRecord record) {
        try {
            MedicalRecord created = medicalRecordService.createMedicalRecord(record);
            return ResponseEntity.status(HttpStatus.CREATED).body(createSuccessResponse("Historial creado", created));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER')")
    public ResponseEntity<?> getAllMedicalRecords() {
        List<MedicalRecord> records = medicalRecordService.getAllMedicalRecords();
        return ResponseEntity.ok(createSuccessResponse("Historiales obtenidos", records));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> getMedicalRecordById(@PathVariable Long id) {
        return medicalRecordService.getMedicalRecordById(id)
            .map(record -> ResponseEntity.ok(createSuccessResponse("Historial encontrado", record)))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/patient/{patientId}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE', 'PATIENT')")
    public ResponseEntity<?> getMedicalRecordsByPatient(@PathVariable Long patientId) {
        List<MedicalRecord> records = medicalRecordService.getMedicalRecordsByPatient(patientId);
        return ResponseEntity.ok(createSuccessResponse("Historiales del paciente", records));
    }

    @GetMapping("/doctor/{doctorId}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER')")
    public ResponseEntity<?> getMedicalRecordsByDoctor(@PathVariable Long doctorId) {
        List<MedicalRecord> records = medicalRecordService.getMedicalRecordsByDoctor(doctorId);
        return ResponseEntity.ok(createSuccessResponse("Historiales del doctor", records));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER')")
    public ResponseEntity<?> updateMedicalRecord(@PathVariable Long id, @RequestBody MedicalRecord record) {
        try {
            MedicalRecord updated = medicalRecordService.updateMedicalRecord(id, record);
            return ResponseEntity.ok(createSuccessResponse("Historial actualizado", updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<?> deleteMedicalRecord(@PathVariable Long id) {
        try {
            medicalRecordService.deleteMedicalRecord(id);
            return ResponseEntity.ok(createSuccessResponse("Historial eliminado", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    private Map<String, Object> createSuccessResponse(String message, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "✅ " + message);
        response.put("data", data);
        return response;
    }

    private Map<String, Object> createErrorResponse(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", "❌ " + message);
        return response;
    }
}