import java.time.LocalDateTime;
import enums.AppointmentStatus;

public record Appointment(Patient patient, Doctor doctor, LocalDateTime appointmentDateTime, AppointmentStatus status) {}
