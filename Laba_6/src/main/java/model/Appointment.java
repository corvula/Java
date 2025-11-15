package model;

import enums.AppointmentStatus;

import java.time.LocalDate;

public class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private AppointmentStatus status;

    public Appointment(int id, Patient patient, Doctor doctor, LocalDate date, AppointmentStatus status) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Appointment{id=" + id + ", patient=" + patient.getName() +
                ", doctor=" + doctor.getName() + ", date=" + date +
                ", status=" + status + "}";
    }
}
