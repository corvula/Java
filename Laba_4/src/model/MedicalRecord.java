package model;

import java.time.LocalDateTime;
import java.util.List;

public class MedicalRecord {
    private Patient patient;
    private String diagnosis;
    private List<String> treatments;
    private LocalDateTime recordDateTime;

    public MedicalRecord(Patient patient, String diagnosis, List<String> treatments, LocalDateTime recordDateTime) {
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.treatments = treatments;
        this.recordDateTime = recordDateTime;
    }

    @Override
    public String toString() {
        return "Record for " + patient.patientId() + ": " + diagnosis + " (" + recordDateTime + ")";
    }
}
