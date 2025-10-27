package tests;

import model.Patient;
import repository.GenericRepository;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {

    @Test
    public void testAddAndFind() {
        GenericRepository<Patient> repo = new GenericRepository<>(Patient::patientId);
        Patient p = new Patient("Anna", "Koval", "P001", LocalDate.of(1995, 5, 12));
        repo.add(p);

        assertTrue(repo.findByIdentity("P001").isPresent());
        assertEquals("Anna", repo.findByIdentity("P001").get().firstName());
    }

    @Test
    public void testRemove() {
        GenericRepository<Patient> repo = new GenericRepository<>(Patient::patientId);
        Patient p = new Patient("Oleh", "Ivanov", "P002", LocalDate.of(1988, 2, 20));
        repo.add(p);
        repo.remove(p);

        assertFalse(repo.findByIdentity("P002").isPresent());
    }
}
