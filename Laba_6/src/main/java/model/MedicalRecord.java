package model;

public class MedicalRecord {
    private int id;
    private Patient patient;
    private String description;

    public MedicalRecord(int id, Patient patient, String description) {
        this.id = id;
        this.patient = patient;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "MedicalRecord{id=" + id + ", patient=" + patient.getName() +
                ", description='" + description + "'}";
    }
}
