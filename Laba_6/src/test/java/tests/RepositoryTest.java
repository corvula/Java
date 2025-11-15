package tests;

import enums.*;
import model.*;
import org.junit.jupiter.api.Test;
import repository.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {

    @Test
    void testFindPatientsByName() {
        PatientRepository repo = new PatientRepository();

        repo.save(new Patient(1, "Ivan", 20));
        repo.save(new Patient(2, "Olga", 31));
        repo.save(new Patient(3, "Ivan", 40));

        List<Patient> result = repo.findByName("Ivan");

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(p -> p.getName().equals("Ivan")));
    }

    @Test
    void testFindPatientsByAgeRange() {
        PatientRepository repo = new PatientRepository();

        repo.save(new Patient(1, "A", 15));
        repo.save(new Patient(2, "B", 30));
        repo.save(new Patient(3, "C", 50));

        List<Patient> result = repo.findByAgeRange(20, 40);

        assertEquals(1, result.size());
        assertEquals(30, result.get(0).getAge());
    }

    @Test
    void testFindDoctorsBySpecialty() {
        DoctorRepository repo = new DoctorRepository();

        repo.save(new Doctor(1, "Dr1", Specialty.CARDIOLOGIST));
        repo.save(new Doctor(2, "Dr2", Specialty.NEUROLOGIST));
        repo.save(new Doctor(3, "Dr3", Specialty.CARDIOLOGIST));

        List<Doctor> result = repo.findBySpecialty(Specialty.CARDIOLOGIST);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(d -> d.getSpecialty() == Specialty.CARDIOLOGIST));
    }

    @Test
    void testFindAppointmentsByStatus() {
        Patient p = new Patient(1, "P", 30);
        Doctor d = new Doctor(1, "D", Specialty.CARDIOLOGIST);

        AppointmentRepository repo = new AppointmentRepository();

        repo.save(new Appointment(1, p, d, LocalDate.now(), AppointmentStatus.PLANNED));
        repo.save(new Appointment(2, p, d, LocalDate.now(), AppointmentStatus.CANCELLED));
        repo.save(new Appointment(3, p, d, LocalDate.now(), AppointmentStatus.PLANNED));

        List<Appointment> result = repo.findByStatus(AppointmentStatus.PLANNED);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(a -> a.getStatus() == AppointmentStatus.PLANNED));
    }

    @Test
    void testFindAppointmentsByDate() {
        Patient p = new Patient(1, "P", 30);
        Doctor d = new Doctor(1, "D", Specialty.CARDIOLOGIST);

        AppointmentRepository repo = new AppointmentRepository();

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);

        repo.save(new Appointment(1, p, d, today, AppointmentStatus.PLANNED));
        repo.save(new Appointment(2, p, d, tomorrow, AppointmentStatus.CANCELLED));

        List<Appointment> result = repo.findByDate(today);

        assertEquals(1, result.size());
        assertEquals(today, result.get(0).getDate());
    }

    @Test
    void testFindMedicationsByType() {
        MedicationRepository repo = new MedicationRepository();

        repo.save(new Medication(1, "A", MedicationType.TABLET));
        repo.save(new Medication(2, "B", MedicationType.INJECTION));
        repo.save(new Medication(3, "C", MedicationType.TABLET));

        List<Medication> result = repo.findByType(MedicationType.TABLET);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(m -> m.getType() == MedicationType.TABLET));
    }

    @Test
    void testFindRecordsByPatientId() {
        Patient p1 = new Patient(1, "Ivan", 20);
        Patient p2 = new Patient(2, "Anna", 25);

        MedicalRecordRepository repo = new MedicalRecordRepository();

        repo.save(new MedicalRecord(1, p1, "Record1"));
        repo.save(new MedicalRecord(2, p2, "Record2"));
        repo.save(new MedicalRecord(3, p1, "Record3"));

        List<MedicalRecord> result = repo.findByPatientId(1);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(r -> r.getPatient().getId() == 1));
    }
}
