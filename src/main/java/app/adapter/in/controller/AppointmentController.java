package app.adapter.in.controller;

import app.domain.model.Appointment;
import app.domain.service.AppointmentService;
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
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Crear cita (Doctores y Admins)
    @PostMapping
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
        try {
            System.out.println("📅 [Controller] Creando cita para paciente: " + appointment.getPatientId());
            Appointment created = appointmentService.createAppointment(appointment);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Cita creada exitosamente");
            response.put("data", created);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            System.err.println("❌ [Controller] Error: " + e.getMessage());
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Listar todas las citas (Admins)
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<?> getAllAppointments() {
        try {
            List<Appointment> appointments = appointmentService.getAllAppointments();
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Citas obtenidas: " + appointments.size());
            response.put("data", appointments);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Obtener cita por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE', 'PATIENT')")
    public ResponseEntity<?> getAppointmentById(@PathVariable Long id) {
        try {
            Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
            
            if (appointment.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(createErrorResponse("Cita no encontrada con ID: " + id));
            }
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Cita encontrada");
            response.put("data", appointment.get());
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Obtener citas por paciente
    @GetMapping("/patient/{patientId}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE', 'PATIENT')")
    public ResponseEntity<?> getAppointmentsByPatient(@PathVariable Long patientId) {
        try {
            List<Appointment> appointments = appointmentService.getAppointmentsByPatient(patientId);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Citas del paciente: " + appointments.size());
            response.put("data", appointments);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Obtener citas por doctor
    @GetMapping("/doctor/{doctorId}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> getAppointmentsByDoctor(@PathVariable Long doctorId) {
        try {
            List<Appointment> appointments = appointmentService.getAppointmentsByDoctor(doctorId);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Citas del doctor: " + appointments.size());
            response.put("data", appointments);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Obtener citas por estado
    @GetMapping("/status/{status}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> getAppointmentsByStatus(@PathVariable String status) {
        try {
            List<Appointment> appointments = appointmentService.getAppointmentsByStatus(status);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Citas con estado " + status + ": " + appointments.size());
            response.put("data", appointments);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Actualizar cita
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        try {
            Appointment updated = appointmentService.updateAppointment(id, appointment);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Cita actualizada exitosamente");
            response.put("data", updated);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Cancelar cita
    @PatchMapping("/{id}/cancel")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE', 'PATIENT')")
    public ResponseEntity<?> cancelAppointment(@PathVariable Long id) {
        try {
            Appointment cancelled = appointmentService.cancelAppointment(id);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Cita cancelada exitosamente");
            response.put("data", cancelled);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Completar cita
    @PatchMapping("/{id}/complete")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER')")
    public ResponseEntity<?> completeAppointment(@PathVariable Long id, @RequestBody(required = false) Map<String, String> body) {
        try {
            String notes = body != null ? body.get("notes") : null;
            Appointment completed = appointmentService.completeAppointment(id, notes);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Cita completada exitosamente");
            response.put("data", completed);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    // Eliminar cita
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long id) {
        try {
            appointmentService.deleteAppointment(id);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "✅ Cita eliminada exitosamente");
            
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