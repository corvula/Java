package repository;

import model.MedicalRecord;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MedicalRecordRepository extends GenericRepository<MedicalRecord> {

    private static final Logger logger = Logger.getLogger(MedicalRecordRepository.class.getName());

    public MedicalRecordRepository() {
        super(MedicalRecord::getId);
    }

    public List<MedicalRecord> findByPatientId(int patientId) {
        logger.info("Searching records for patient id: " + patientId);
        return findAll().stream()
                .filter(r -> r.getPatient().getId() == patientId)
                .collect(Collectors.toList());
    }
}
