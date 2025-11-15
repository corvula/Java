package org.example.medical;

import org.example.medical.exception.InvalidDataException;
import org.example.medical.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MedicalRecordTest {

    @Test
    void testValidMedicalRecord() {
        Patient p = new Patient("P","Q","99", LocalDate.of(1999,1,1));
        MedicalRecord r = new MedicalRecord(p, "Flu", List.of("Rest", "Fluids"), LocalDateTime.now());
        assertNotNull(r);
        assertEquals("Flu", r.getDiagnosis());
    }

    @Test
    void testInvalidMedicalRecord() {
        InvalidDataException ex = assertThrows(InvalidDataException.class, () ->
                new MedicalRecord(null, "", List.of(), null)
        );
        String msg = ex.getMessage();
        assertTrue(msg.contains("patient: cannot be null"));
        assertTrue(msg.contains("diagnosis: cannot be empty"));
        assertTrue(msg.contains("treatments: cannot be empty"));
        assertTrue(msg.contains("recordDateTime: cannot be null"));
    }
}
