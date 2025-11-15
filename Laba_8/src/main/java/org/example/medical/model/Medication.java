package org.example.medical.model;

import org.example.medical.exception.InvalidDataException;
import org.example.medical.util.LoggerUtil;

import java.util.ArrayList;
import java.util.List;

public class Medication {
    private String name;
    private String dosage;
    private String instructions;
    private MedicationType type;

    public Medication(String name, String dosage, String instructions, MedicationType type) {
        LoggerUtil.logInfo("Attempt to create Medication: " + name);
        List<String> errors = new ArrayList<>();
        if (name == null || name.isBlank()) errors.add("name: cannot be empty");
        if (dosage == null || dosage.isBlank()) errors.add("dosage: cannot be empty");
        if (instructions == null || instructions.isBlank()) errors.add("instructions: cannot be empty");
        if (type == null) errors.add("type: cannot be null");
        if (!errors.isEmpty()) {
            LoggerUtil.logError("Medication validation failed: " + String.join("; ", errors));
            throw new InvalidDataException(String.join("; ", errors));
        }
        this.name = name;
        this.dosage = dosage;
        this.instructions = instructions;
        this.type = type;
        LoggerUtil.logInfo("Medication created: " + name);
    }

    public String getName() { return name; }
    public String getDosage() { return dosage; }
    public String getInstructions() { return instructions; }
    public MedicationType getType() { return type; }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new InvalidDataException("name: cannot be empty");
        this.name = name;
    }

    public void setDosage(String dosage) {
        if (dosage == null || dosage.isBlank()) throw new InvalidDataException("dosage: cannot be empty");
        this.dosage = dosage;
    }

    public void setInstructions(String instructions) {
        if (instructions == null || instructions.isBlank()) throw new InvalidDataException("instructions: cannot be empty");
        this.instructions = instructions;
    }

    public void setType(MedicationType type) {
        if (type == null) throw new InvalidDataException("type: cannot be null");
        this.type = type;
    }
}
