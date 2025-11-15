package org.example.medical;

import org.example.medical.model.*;
import org.example.medical.repository.*;
import org.example.medical.util.LoggerUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LoggerUtil.logInfo("Starting Medical Center demo");

        PatientRepository pr = new PatientRepository();
        DoctorRepository dr = new DoctorRepository();

        Patient p = new Patient("Alice", "Smith", "P100", LocalDate.of(1990, 1, 1));
        pr.save(p);

        Doctor d = new Doctor("Bob", "Jones", Specialty.CARDIOLOGIST);
        dr.save(d);

        Appointment ap = new Appointment(p, d, LocalDateTime.now().plusDays(1), AppointmentStatus.SCHEDULED);
        LoggerUtil.logInfo("Demo finished. Created appointment for " + ap.getPatient().patientId());
    }
}
