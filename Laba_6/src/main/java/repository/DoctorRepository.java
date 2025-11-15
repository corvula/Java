package repository;

import model.Doctor;
import enums.Specialty;

import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Logger;

public class DoctorRepository extends GenericRepository<Doctor> {

    private static final Logger logger = Logger.getLogger(DoctorRepository.class.getName());

    public DoctorRepository() {
        super(Doctor::getId);
    }

    public List<Doctor> findBySpecialty(Specialty specialty) {
        logger.info("Searching doctors by specialty: " + specialty);
        return findAll().stream()
                .filter(d -> d.getSpecialty() == specialty)
                .collect(Collectors.toList());
    }
}
