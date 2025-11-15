package org.example.medical.model;

import org.example.medical.exception.InvalidDataException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record Patient(String firstName, String lastName, String patientId, LocalDate birthDate) {
    public Patient {
        List<String> errors = new ArrayList<>();
        if (firstName == null || firstName.isBlank()) errors.add("firstName: cannot be empty");
        if (lastName == null || lastName.isBlank()) errors.add("lastName: cannot be empty");
        if (patientId == null || patientId.isBlank()) errors.add("patientId: cannot be empty");
        if (birthDate == null) errors.add("birthDate: cannot be null");
        else if (birthDate.isAfter(LocalDate.now())) errors.add("birthDate: cannot be in the future");
        if (!errors.isEmpty()) throw new InvalidDataException(String.join("; ", errors));
    }
}
