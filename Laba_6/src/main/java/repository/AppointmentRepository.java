package repository;

import model.Appointment;
import enums.AppointmentStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AppointmentRepository extends GenericRepository<Appointment> {

    private static final Logger logger = Logger.getLogger(AppointmentRepository.class.getName());

    public AppointmentRepository() {
        super(Appointment::getId);
    }

    public List<Appointment> findByStatus(AppointmentStatus status) {
        logger.info("Searching appointments by status: " + status);
        return findAll().stream()
                .filter(a -> a.getStatus() == status)
                .collect(Collectors.toList());
    }

    public List<Appointment> findByDate(LocalDate date) {
        logger.info("Searching appointments by date: " + date);
        return findAll().stream()
                .filter(a -> a.getDate().equals(date))
                .collect(Collectors.toList());
    }
}
