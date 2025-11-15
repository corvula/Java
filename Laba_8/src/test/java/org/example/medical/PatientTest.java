package org.example.medical;

import org.example.medical.exception.InvalidDataException;
import org.example.medical.model.Patient;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    @Test
    void testValidPatientCreation() {
        Patient p = new Patient("John", "Doe", "P001", LocalDate.of(1990, 5, 1));
        assertNotNull(p);
        assertEquals("John", p.firstName());
    }

    @Test
    void testInvalidPatientCreation() {
        InvalidDataException ex = assertThrows(InvalidDataException.class, () ->
                new Patient("", "", "", LocalDate.of(2050, 1, 1))
        );
        String msg = ex.getMessage();
        assertTrue(msg.contains("firstName: cannot be empty"));
        assertTrue(msg.contains("lastName: cannot be empty"));
        assertTrue(msg.contains("patientId: cannot be empty"));
        assertTrue(msg.contains("birthDate: cannot be in the future"));
    }
}
