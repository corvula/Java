package org.example.medical.model;

import org.example.medical.exception.InvalidDataException;

import java.util.ArrayList;
import java.util.List;

public record Doctor(String firstName, String lastName, Specialty specialty) {
    public Doctor {
        List<String> errors = new ArrayList<>();
        if (firstName == null || firstName.isBlank()) errors.add("firstName: cannot be empty");
        if (lastName == null || lastName.isBlank()) errors.add("lastName: cannot be empty");
        if (specialty == null) errors.add("specialty: cannot be null");
        if (!errors.isEmpty()) throw new InvalidDataException(String.join("; ", errors));
    }
}
