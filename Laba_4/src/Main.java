import enums.*;
import model.*;
import repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        GenericRepository<Patient> patientRepo = new GenericRepository<>(Patient::patientId);
        Patient p1 = new Patient("Anna", "Koval", "P001", LocalDate.of(1995, 5, 12));
        Patient p2 = new Patient("Oleh", "Ivanov", "P002", LocalDate.of(1988, 2, 20));
        patientRepo.add(p1);
        patientRepo.add(p2);

        GenericRepository<Doctor> doctorRepo = new GenericRepository<>(d -> d.lastName() + "_" + d.specialty());
        Doctor d1 = new Doctor("Marta", "Bila", Specialty.CARDIOLOGIST);
        Doctor d2 = new Doctor("Ivan", "Hrytsenko", Specialty.NEUROLOGIST);
        doctorRepo.add(d1);
        doctorRepo.add(d2);

        System.out.println("Find patient P002: " + patientRepo.findByIdentity("P002").orElse(null));
        System.out.println("Find doctor Bila_CARDIOLOGIST: " + doctorRepo.findByIdentity("Bila_CARDIOLOGIST").orElse(null));

        patientRepo.add(p1);

        System.out.println("All patients:");
        patientRepo.getAll().forEach(System.out::println);
    }
}
