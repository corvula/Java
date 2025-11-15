package org.example.medical.model;

import org.example.medical.exception.InvalidDataException;

import java.time.LocalDate;

public record Patient(String firstName, String lastName, String patientId, LocalDate birthDate) {
    public Patient {
        StringBuilder errors = new StringBuilder();
        if (firstName == null || firstName.trim().isEmpty()) errors.append("firstName invalid; ");
        if (lastName == null || lastName.trim().isEmpty()) errors.append("lastName invalid; ");
        if (patientId == null || patientId.trim().isEmpty()) errors.append("patientId invalid; ");
        if (birthDate == null || birthDate.isAfter(LocalDate.now())) errors.append("birthDate invalid; ");
        if (errors.length() > 0) throw new InvalidDataException(errors.toString());
    }
}
