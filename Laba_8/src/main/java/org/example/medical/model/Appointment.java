package org.example.medical.model;

import org.example.medical.exception.InvalidDataException;

import java.time.LocalDateTime;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDateTime;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime appointmentDateTime) {
        setPatient(patient);
        setDoctor(doctor);
        setAppointmentDateTime(appointmentDateTime);
    }

    public void setPatient(Patient p) {
        if (p == null) throw new InvalidDataException("patient invalid");
        this.patient = p;
    }

    public void setDoctor(Doctor d) {
        if (d == null) throw new InvalidDataException("doctor invalid");
        this.doctor = d;
    }

    public void setAppointmentDateTime(LocalDateTime dt) {
        if (dt == null || dt.isBefore(LocalDateTime.now()))
            throw new InvalidDataException("appointmentDateTime invalid");
        this.appointmentDateTime = dt;
    }
}
