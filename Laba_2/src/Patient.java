import java.time.LocalDate;

public record Patient(String firstName, String lastName, int patientId, LocalDate birthDate) {}
