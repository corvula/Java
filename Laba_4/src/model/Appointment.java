package model;

import enums.AppointmentStatus;
import java.time.LocalDateTime;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDateTime;
    private AppointmentStatus status;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime appointmentDateTime, AppointmentStatus status) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDateTime = appointmentDateTime;
        this.status = status;
    }

    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getAppointmentDateTime() { return appointmentDateTime; }
    public AppointmentStatus getStatus() { return status; }

    @Override
    public String toString() {
        return "Appointment{" +
                "patient=" + patient.patientId() +
                ", doctor=" + doctor.lastName() +
                ", time=" + appointmentDateTime +
                ", status=" + status +
                '}';
    }
}
