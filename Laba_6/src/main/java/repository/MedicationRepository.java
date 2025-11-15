package repository;

import model.Medication;
import enums.MedicationType;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MedicationRepository extends GenericRepository<Medication> {

    private static final Logger logger = Logger.getLogger(MedicationRepository.class.getName());

    public MedicationRepository() {
        super(Medication::getId);
    }

    public List<Medication> findByType(MedicationType type) {
        logger.info("Searching medications by type: " + type);
        return findAll().stream()
                .filter(m -> m.getType() == type)
                .collect(Collectors.toList());
    }
}
