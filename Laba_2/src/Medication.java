import enums.MedicationType;

public record Medication(String name, String dosage, MedicationType type, String instructions) {}
