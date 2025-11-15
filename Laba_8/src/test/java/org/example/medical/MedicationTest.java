package org.example.medical;

import org.example.medical.exception.InvalidDataException;
import org.example.medical.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MedicationTest {

    @Test
    void testValidMedication() {
        Medication m = new Medication("Paracetamol", "500mg", "Take after food", MedicationType.TABLET);
        assertNotNull(m);
        assertEquals("Paracetamol", m.getName());
    }

    @Test
    void testInvalidMedication() {
        InvalidDataException ex = assertThrows(InvalidDataException.class, () ->
                new Medication("", "", "", null)
        );
        String msg = ex.getMessage();
        assertTrue(msg.contains("name: cannot be empty"));
        assertTrue(msg.contains("dosage: cannot be empty"));
        assertTrue(msg.contains("instructions: cannot be empty"));
        assertTrue(msg.contains("type: cannot be null"));
    }
}
