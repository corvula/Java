package org.example.medical.model;

import org.example.medical.exception.InvalidDataException;
import org.example.medical.util.LoggerUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDateTime;
    private AppointmentStatus status;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime appointmentDateTime, AppointmentStatus status) {
        LoggerUtil.logInfo("Attempt to create Appointment for patient " + (patient == null ? "null" : patient.patientId()));
        List<String> errors = new ArrayList<>();
        if (patient == null) errors.add("patient: cannot be null");
        if (doctor == null) errors.add("doctor: cannot be null");
        if (appointmentDateTime == null) errors.add("appointmentDateTime: cannot be null");
        else if (appointmentDateTime.isBefore(LocalDateTime.now())) errors.add("appointmentDateTime: must be in the future");
        if (status == null) errors.add("status: cannot be null");
        if (!errors.isEmpty()) {
            LoggerUtil.logError("Appointment validation failed: " + String.join("; ", errors));
            throw new InvalidDataException(String.join("; ", errors));
        }
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDateTime = appointmentDateTime;
        this.status = status;
        LoggerUtil.logInfo("Appointment created successfully for patient " + patient.patientId());
    }

    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getAppointmentDateTime() { return appointmentDateTime; }
    public AppointmentStatus getStatus() { return status; }

    public void setPatient(Patient patient) {
        if (patient == null) throw new InvalidDataException("patient: cannot be null");
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        if (doctor == null) throw new InvalidDataException("doctor: cannot be null");
        this.doctor = doctor;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        if (appointmentDateTime == null) throw new InvalidDataException("appointmentDateTime: cannot be null");
        if (appointmentDateTime.isBefore(LocalDateTime.now())) throw new InvalidDataException("appointmentDateTime: must be in the future");
        this.appointmentDateTime = appointmentDateTime;
    }

    public void setStatus(AppointmentStatus status) {
        if (status == null) throw new InvalidDataException("status: cannot be null");
        this.status = status;
    }
}
