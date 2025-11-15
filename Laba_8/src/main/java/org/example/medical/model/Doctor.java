package org.example.medical.model;

import org.example.medical.exception.InvalidDataException;

public record Doctor(String firstName, String lastName, Specialty specialty) {
    public Doctor {
        StringBuilder errors = new StringBuilder();
        if (firstName == null || firstName.trim().isEmpty()) errors.append("firstName invalid; ");
        if (lastName == null || lastName.trim().isEmpty()) errors.append("lastName invalid; ");
        if (specialty == null) errors.append("specialty invalid; ");
        if (errors.length() > 0) throw new InvalidDataException(errors.toString());
    }
}
