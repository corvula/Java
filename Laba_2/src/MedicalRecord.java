import java.time.LocalDateTime;

public record MedicalRecord(Patient patient, String diagnosis, String treatments, LocalDateTime recordDateTime) {}
