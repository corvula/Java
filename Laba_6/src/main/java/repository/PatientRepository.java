package repository;

import model.Patient;

import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Logger;

public class PatientRepository extends GenericRepository<Patient> {

    private static final Logger logger = Logger.getLogger(PatientRepository.class.getName());

    public PatientRepository() {
        super(Patient::getId);
    }

    public List<Patient> findByName(String name) {
        logger.info("Searching patients by name: " + name);
        return findAll().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Patient> findByAgeRange(int min, int max) {
        logger.info("Searching by age range: " + min + "-" + max);
        return findAll().stream()
                .filter(p -> p.getAge() >= min && p.getAge() <= max)
                .collect(Collectors.toList());
    }
}
