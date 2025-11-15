package org.example.medical.model;

import org.example.medical.exception.InvalidDataException;

public class Medication {
    private String name;
    private String dosage;
    private String instructions;
    private MedicationType type;

    public Medication(String name, String dosage, String instructions, MedicationType type) {
        setName(name);
        setDosage(dosage);
        setInstructions(instructions);
        setType(type);
    }

    public void setName(String v) {
        if (v == null || v.trim().isEmpty()) throw new InvalidDataException("name invalid");
        name = v;
    }

    public void setDosage(String v) {
        if (v == null || v.trim().isEmpty()) throw new InvalidDataException("dosage invalid");
        dosage = v;
    }

    public void setInstructions(String v) {
        if (v == null || v.trim().isEmpty()) throw new InvalidDataException("instructions invalid");
        instructions = v;
    }

    public void setType(MedicationType v) {
        if (v == null) throw new InvalidDataException("type invalid");
        type = v;
    }
}
