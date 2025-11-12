package app.adapter.in.controller;

import app.domain.model.Patient;
import app.domain.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Crear paciente
    @PostMapping
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> createPatient(@RequestBody Patient patient) {
        try {
            System.out.println("👤 [Controller] Creando paciente: " + patient.getFullName());
            Patient created = patientService.createPatient(patient);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Paciente creado exitosamente: " + created.getFullName());
            response.put("data", created);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            System.err.println("❌ [Controller] Error de validación: " + e.getMessage());
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        } catch (Exception e) {
            System.err.println("❌ [Controller] Error: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(createErrorResponse("Error interno del servidor"));
        }
    }

    // Listar todos los pacientes
    @GetMapping
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> getAllPatients() {
        try {
            List<Patient> patients = patientService.getAllPatients();
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Total de pacientes: " + patients.size());
            response.put("data", patients);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Obtener paciente por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE', 'PATIENT')")
    public ResponseEntity<?> getPatientById(@PathVariable Long id) {
        try {
            Optional<Patient> patient = patientService.getPatientById(id);
            
            if (patient.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(createErrorResponse("Paciente no encontrado con ID: " + id));
            }
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Paciente encontrado: " + patient.get().getFullName());
            response.put("data", patient.get());
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Buscar paciente por documento
    @GetMapping("/document/{documentId}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> getPatientByDocument(@PathVariable String documentId) {
        try {
            Optional<Patient> patient = patientService.getPatientByDocument(documentId);
            
            if (patient.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(createErrorResponse("Paciente no encontrado con documento: " + documentId));
            }
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Paciente encontrado");
            response.put("data", patient.get());
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Buscar pacientes por nombre
    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> searchPatientsByName(@RequestParam String name) {
        try {
            List<Patient> patients = patientService.searchPatientsByName(name);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Pacientes encontrados: " + patients.size());
            response.put("data", patients);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Buscar por tipo de sangre
    @GetMapping("/blood-type/{bloodType}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> getPatientsByBloodType(@PathVariable String bloodType) {
        try {
            List<Patient> patients = patientService.getPatientsByBloodType(bloodType);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Pacientes con tipo de sangre " + bloodType + ": " + patients.size());
            response.put("data", patients);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Buscar por género
    @GetMapping("/gender/{gender}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> getPatientsByGender(@PathVariable String gender) {
        try {
            List<Patient> patients = patientService.getPatientsByGender(gender);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Pacientes con género " + gender + ": " + patients.size());
            response.put("data", patients);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Actualizar paciente
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        try {
            Patient updated = patientService.updatePatient(id, patient);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Paciente actualizado: " + updated.getFullName());
            response.put("data", updated);
            
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(createErrorResponse("Error interno del servidor"));
        }
    }

    // Actualizar historial médico
    @PatchMapping("/{id}/medical-history")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER')")
    public ResponseEntity<?> updateMedicalHistory(@PathVariable Long id, @RequestBody Map<String, String> body) {
        try {
            String medicalHistory = body.get("medicalHistory");
            if (medicalHistory == null) {
                return ResponseEntity.badRequest().body(createErrorResponse("El campo 'medicalHistory' es requerido"));
            }
            
            Patient updated = patientService.updateMedicalHistory(id, medicalHistory);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Historial médico actualizado");
            response.put("data", updated);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Actualizar alergias
    @PatchMapping("/{id}/allergies")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> updateAllergies(@PathVariable Long id, @RequestBody Map<String, String> body) {
        try {
            String allergies = body.get("allergies");
            if (allergies == null) {
                return ResponseEntity.badRequest().body(createErrorResponse("El campo 'allergies' es requerido"));
            }
            
            Patient updated = patientService.updateAllergies(id, allergies);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Alergias actualizadas");
            response.put("data", updated);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Eliminar paciente
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        try {
            patientService.deletePatient(id);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Paciente eliminado exitosamente");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Obtener estadísticas
    @GetMapping("/stats/total")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<?> getTotalPatients() {
        try {
            long total = patientService.getTotalPatients();
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Total de pacientes registrados");
            response.put("total", total);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    private Map<String, Object> createErrorResponse(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", "❌ " + message);
        return response;
    }
}