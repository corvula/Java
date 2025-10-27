package model;

import enums.MedicationType;

public class Medication {
    private String name;
    private double dosage;
    private String instructions;
    private MedicationType type;

    public Medication(String name, double dosage, String instructions, MedicationType type) {
        this.name = name;
        this.dosage = dosage;
        this.instructions = instructions;
        this.type = type;
    }

    public String getName() { return name; }
    public double getDosage() { return dosage; }
    public String getInstructions() { return instructions; }
    public MedicationType getType() { return type; }

    @Override
    public String toString() {
        return name + " (" + dosage + "mg, " + type + ")";
    }
}
