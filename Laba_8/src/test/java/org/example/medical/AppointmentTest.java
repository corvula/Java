package org.example.medical;

import org.example.medical.exception.InvalidDataException;
import org.example.medical.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    void testValidAppointmentCreation() {
        Patient p = new Patient("A","B","1", LocalDate.of(2000,1,1));
        Doctor d = new Doctor("X","Y", Specialty.DERMATOLOGIST);
        Appointment a = new Appointment(p, d, LocalDateTime.now().plusDays(1), AppointmentStatus.SCHEDULED);
        assertNotNull(a);
        assertEquals(p, a.getPatient());
    }

    @Test
    void testInvalidAppointmentPastDate() {
        Patient p = new Patient("A","B","1", LocalDate.of(2000,1,1));
        Doctor d = new Doctor("X","Y", Specialty.DERMATOLOGIST);
        InvalidDataException ex = assertThrows(InvalidDataException.class, () ->
                new Appointment(p, d, LocalDateTime.now().minusDays(1), AppointmentStatus.SCHEDULED)
        );
        assertTrue(ex.getMessage().contains("appointmentDateTime: must be in the future"));
    }
}
