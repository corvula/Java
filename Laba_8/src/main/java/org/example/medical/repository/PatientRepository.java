package org.example.medical.repository;

import org.example.medical.model.Patient;

public class PatientRepository extends Repository<Patient> {
    public Patient getById(String id) {
        return data.stream().filter(p -> p.patientId().equals(id)).findFirst().orElse(null);
    }
}
