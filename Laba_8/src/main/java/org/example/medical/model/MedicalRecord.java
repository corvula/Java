package org.example.medical.model;

import org.example.medical.exception.InvalidDataException;

import java.time.LocalDateTime;
import java.util.List;

public class MedicalRecord {
    private Patient patient;
    private String diagnosis;
    private List<String> treatments;
    private LocalDateTime recordDateTime;

    public MedicalRecord(Patient patient, String diagnosis, List<String> treatments, LocalDateTime recordDateTime) {
        setPatient(patient);
        setDiagnosis(diagnosis);
        setTreatments(treatments);
        setRecordDateTime(recordDateTime);
    }

    public void setPatient(Patient p) {
        if (p == null) throw new InvalidDataException("patient invalid");
        patient = p;
    }

    public void setDiagnosis(String d) {
        if (d == null || d.trim().isEmpty()) throw new InvalidDataException("diagnosis invalid");
        diagnosis = d;
    }

    public void setTreatments(List<String> t) {
        if (t == null || t.isEmpty()) throw new InvalidDataException("treatments invalid");
        treatments = t;
    }

    public void setRecordDateTime(LocalDateTime dt) {
        if (dt == null || dt.isAfter(LocalDateTime.now())) throw new InvalidDataException("recordDateTime invalid");
        recordDateTime = dt;
    }
}
