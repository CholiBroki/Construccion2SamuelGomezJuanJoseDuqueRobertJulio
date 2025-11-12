package app.domain.repository;

import app.domain.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    
    // Buscar citas por paciente
    List<Appointment> findByPatientId(Long patientId);
    
    // Buscar citas por doctor
    List<Appointment> findByDoctorId(Long doctorId);
    
    // Buscar citas por estado
    List<Appointment> findByStatus(String status);
    
    // Buscar citas en un rango de fechas
    List<Appointment> findByAppointmentDateTimeBetween(LocalDateTime start, LocalDateTime end);
    
    // Buscar citas de un doctor en una fecha específica
    List<Appointment> findByDoctorIdAndAppointmentDateTimeBetween(
        Long doctorId, 
        LocalDateTime start, 
        LocalDateTime end
    );
}