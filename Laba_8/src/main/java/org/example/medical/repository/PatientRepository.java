package org.example.medical.repository;

import org.example.medical.model.Patient;
import org.example.medical.exception.InvalidDataException;
import org.example.medical.util.LoggerUtil;

import java.util.*;

public class PatientRepository implements Repository<Patient, String> {
    private final Map<String, Patient> storage = new HashMap<>();

    @Override
    public Patient save(Patient patient) {
        LoggerUtil.logInfo("Attempt to save patient: " + (patient == null ? "null" : patient.patientId()));
        if (patient == null) throw new InvalidDataException("patient: cannot be null");

        storage.put(patient.patientId(), patient);
        LoggerUtil.logInfo("Patient saved: " + patient.patientId());
        return patient;
    }

    @Override
    public Optional<Patient> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Patient> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(String id) {
        storage.remove(id);
    }
}
