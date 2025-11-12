package app.domain.service;

import app.domain.model.Appointment;
import app.domain.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Crear cita
    public Appointment createAppointment(Appointment appointment) {
        System.out.println("📅 [AppointmentService] Creando cita para paciente ID: " + appointment.getPatientId());
        
        // Validar que la fecha sea futura
        if (appointment.getAppointmentDateTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de la cita debe ser en el futuro");
        }
        
        Appointment saved = appointmentRepository.save(appointment);
        System.out.println("✅ [AppointmentService] Cita creada con ID: " + saved.getId());
        return saved;
    }

    // Obtener cita por ID
    public Optional<Appointment> getAppointmentById(Long id) {
        System.out.println("🔍 [AppointmentService] Buscando cita ID: " + id);
        return appointmentRepository.findById(id);
    }

    // Listar todas las citas
    public List<Appointment> getAllAppointments() {
        System.out.println("📋 [AppointmentService] Listando todas las citas");
        return appointmentRepository.findAll();
    }

    // Obtener citas por paciente
    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        System.out.println("🔍 [AppointmentService] Buscando citas del paciente ID: " + patientId);
        return appointmentRepository.findByPatientId(patientId);
    }

    // Obtener citas por doctor
    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        System.out.println("🔍 [AppointmentService] Buscando citas del doctor ID: " + doctorId);
        return appointmentRepository.findByDoctorId(doctorId);
    }

    // Obtener citas por estado
    public List<Appointment> getAppointmentsByStatus(String status) {
        System.out.println("🔍 [AppointmentService] Buscando citas con estado: " + status);
        return appointmentRepository.findByStatus(status);
    }

    // Actualizar cita
    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        System.out.println("✏️ [AppointmentService] Actualizando cita ID: " + id);
        
        Optional<Appointment> existing = appointmentRepository.findById(id);
        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Cita no encontrada con ID: " + id);
        }
        
        Appointment appointment = existing.get();
        
        if (updatedAppointment.getAppointmentDateTime() != null) {
            appointment.setAppointmentDateTime(updatedAppointment.getAppointmentDateTime());
        }
        if (updatedAppointment.getStatus() != null) {
            appointment.setStatus(updatedAppointment.getStatus());
        }
        if (updatedAppointment.getNotes() != null) {
            appointment.setNotes(updatedAppointment.getNotes());
        }
        if (updatedAppointment.getReason() != null) {
            appointment.setReason(updatedAppointment.getReason());
        }
        
        Appointment saved = appointmentRepository.save(appointment);
        System.out.println("✅ [AppointmentService] Cita actualizada");
        return saved;
    }

    // Cancelar cita
    public Appointment cancelAppointment(Long id) {
        System.out.println("❌ [AppointmentService] Cancelando cita ID: " + id);
        
        Optional<Appointment> existing = appointmentRepository.findById(id);
        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Cita no encontrada con ID: " + id);
        }
        
        Appointment appointment = existing.get();
        appointment.setStatus("CANCELLED");
        
        Appointment saved = appointmentRepository.save(appointment);
        System.out.println("✅ [AppointmentService] Cita cancelada");
        return saved;
    }

    // Completar cita
    public Appointment completeAppointment(Long id, String notes) {
        System.out.println("✅ [AppointmentService] Completando cita ID: " + id);
        
        Optional<Appointment> existing = appointmentRepository.findById(id);
        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Cita no encontrada con ID: " + id);
        }
        
        Appointment appointment = existing.get();
        appointment.setStatus("COMPLETED");
        if (notes != null) {
            appointment.setNotes(notes);
        }
        
        Appointment saved = appointmentRepository.save(appointment);
        System.out.println("✅ [AppointmentService] Cita completada");
        return saved;
    }

    // Eliminar cita
    public void deleteAppointment(Long id) {
        System.out.println("🗑️ [AppointmentService] Eliminando cita ID: " + id);
        
        if (!appointmentRepository.existsById(id)) {
            throw new IllegalArgumentException("Cita no encontrada con ID: " + id);
        }
        
        appointmentRepository.deleteById(id);
        System.out.println("✅ [AppointmentService] Cita eliminada");
    }
}