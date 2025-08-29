package app.application.port.in;

public interface VeterinaryUseCase {
    void scheduleAppointment(String petId, String date);
}