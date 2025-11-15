import repository.*;
import model.*;
import enums.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        PatientRepository patientRepo = new PatientRepository();
        DoctorRepository doctorRepo = new DoctorRepository();
        AppointmentRepository appointmentRepo = new AppointmentRepository();

        Patient p1 = new Patient(1, "Ivan", 20);
        Patient p2 = new Patient(2, "Olga", 31);
        Patient p3 = new Patient(3, "Ivan", 44);

        patientRepo.save(p1);
        patientRepo.save(p2);
        patientRepo.save(p3);

        Doctor d1 = new Doctor(1, "Dr. House", Specialty.CARDIOLOGIST);
        Doctor d2 = new Doctor(2, "Dr. Wilson", Specialty.DERMATOLOGIST);

        doctorRepo.save(d1);
        doctorRepo.save(d2);

        Appointment a1 = new Appointment(1, p1, d1, LocalDate.now(), AppointmentStatus.PLANNED);
        Appointment a2 = new Appointment(2, p2, d2, LocalDate.now().plusDays(1), AppointmentStatus.CANCELLED);

        appointmentRepo.save(a1);
        appointmentRepo.save(a2);

        System.out.println("Patients named Ivan:");
        patientRepo.findByName("Ivan").forEach(System.out::println);

        System.out.println("\nDoctors (Cardiologists):");
        doctorRepo.findBySpecialty(Specialty.CARDIOLOGIST).forEach(System.out::println);

        System.out.println("\nAppointments today:");
        appointmentRepo.findByDate(LocalDate.now()).forEach(System.out::println);

        long t1 = System.currentTimeMillis();
        patientRepo.findAll().stream().map(p -> p.getName().toUpperCase()).forEach(s -> {});
        long timeStream = System.currentTimeMillis() - t1;

        long t2 = System.currentTimeMillis();
        patientRepo.findAll().parallelStream().map(p -> p.getName().toUpperCase()).forEach(s -> {});
        long timeParallel = System.currentTimeMillis() - t2;

        System.out.println("\nStream time: " + timeStream + " ms");
        System.out.println("ParallelStream time: " + timeParallel + " ms");
    }
}
