import java.time.LocalDate;
import java.time.LocalDateTime;

import enums.Specialty;
import enums.MedicationType;
import enums.AppointmentStatus;

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient("Olena", "Shevchenko", 101, LocalDate.of(1992, 5, 14));
        Doctor doctor = new Doctor("Ivan", "Petrenko", Specialty.CARDIOLOGIST);
        Medication medication = new Medication("Aspirin", "100mg", MedicationType.TABLET, "Take once daily after meals");
        Appointment appointment = new Appointment(patient, doctor, LocalDateTime.of(2025, 10, 25, 10, 30), AppointmentStatus.SCHEDULED);
        MedicalRecord record = new MedicalRecord(patient, "Mild hypertension", "Aspirin + lifestyle changes", LocalDateTime.now());

        System.out.println("---- Medical Center System ----");
        System.out.println("Patient: " + patient.firstName() + " " + patient.lastName());
        System.out.println("Doctor: " + doctor.firstName() + " " + doctor.lastName() + " (" + doctor.specialty() + ")");
        System.out.println("Appointment: " + appointment.appointmentDateTime() + " | Status: " + appointment.status());
        System.out.println("Medication: " + medication.name() + " (" + medication.type() + ")");
        System.out.println("Medical Record: " + record.diagnosis());


        System.out.println("\nAppointment status check:");
        switch (appointment.status()) {
            case SCHEDULED -> System.out.println(" Appointment is scheduled and awaiting confirmation.");
            case COMPLETED -> System.out.println(" Appointment completed successfully.");
            case CANCELED -> System.out.println(" Appointment has been canceled.");
            case NO_SHOW -> System.out.println("Patient did not show up.");
        }

        String advice = switch (doctor.specialty()) {
            case GENERAL_PRACTITIONER -> "Perform general health check-ups.";
            case CARDIOLOGIST -> "Monitor patient’s heart condition.";
            case DERMATOLOGIST -> "Check skin and recommend proper treatment.";
            case PEDIATRICIAN -> "Focus on child’s growth and development.";
            case NEUROLOGIST -> "Evaluate and treat nervous system disorders.";
        };
        System.out.println("\nDoctor’s advice: " + advice);

        String medForm = switch (medication.type()) {
            case TABLET -> "Tablets are taken orally.";
            case SYRUP -> "Syrups are liquid medications.";
            case INJECTION -> "Injections are administered directly.";
            case OINTMENT -> "Ointments are applied externally.";
        };
        System.out.println("Medication info: " + medForm);
    }
}
