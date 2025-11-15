package org.example.medical.model;

import org.example.medical.exception.InvalidDataException;
import org.example.medical.util.LoggerUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
    private Patient patient;
    private String diagnosis;
    private List<String> treatments;
    private LocalDateTime recordDateTime;

    public MedicalRecord(Patient patient, String diagnosis, List<String> treatments, LocalDateTime recordDateTime) {
        LoggerUtil.logInfo("Attempt to create MedicalRecord for patient " + (patient == null ? "null" : patient.patientId()));
        List<String> errors = new ArrayList<>();
        if (patient == null) errors.add("patient: cannot be null");
        if (diagnosis == null || diagnosis.isBlank()) errors.add("diagnosis: cannot be empty");
        if (treatments == null || treatments.isEmpty()) errors.add("treatments: cannot be empty");
        if (recordDateTime == null) errors.add("recordDateTime: cannot be null");
        if (!errors.isEmpty()) {
            LoggerUtil.logError("MedicalRecord validation failed: " + String.join("; ", errors));
            throw new InvalidDataException(String.join("; ", errors));
        }
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.treatments = treatments;
        this.recordDateTime = recordDateTime;
        LoggerUtil.logInfo("MedicalRecord created for patient " + patient.patientId());
    }

    public Patient getPatient() { return patient; }
    public String getDiagnosis() { return diagnosis; }
    public List<String> getTreatments() { return treatments; }
    public LocalDateTime getRecordDateTime() { return recordDateTime; }

    public void setPatient(Patient patient) {
        if (patient == null) throw new InvalidDataException("patient: cannot be null");
        this.patient = patient;
    }

    public void setDiagnosis(String diagnosis) {
        if (diagnosis == null || diagnosis.isBlank()) throw new InvalidDataException("diagnosis: cannot be empty");
        this.diagnosis = diagnosis;
    }

    public void setTreatments(List<String> treatments) {
        if (treatments == null || treatments.isEmpty()) throw new InvalidDataException("treatments: cannot be empty");
        this.treatments = treatments;
    }

    public void setRecordDateTime(java.time.LocalDateTime recordDateTime) {
        if (recordDateTime == null) throw new InvalidDataException("recordDateTime: cannot be null");
        this.recordDateTime = recordDateTime;
    }
}
