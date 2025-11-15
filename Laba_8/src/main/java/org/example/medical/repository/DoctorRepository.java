package org.example.medical.repository;

import org.example.medical.model.Doctor;
import org.example.medical.exception.InvalidDataException;
import org.example.medical.util.LoggerUtil;

import java.util.*;

public class DoctorRepository implements Repository<Doctor, String> {
    private final Map<String, Doctor> storage = new HashMap<>();

    @Override
    public Doctor save(Doctor doctor) {
        LoggerUtil.logInfo("Attempt to save doctor: " + (doctor == null ? "null" : doctor.firstName() + " " + doctor.lastName()));
        if (doctor == null) throw new InvalidDataException("doctor: cannot be null");
        String key = doctor.firstName() + "_" + doctor.lastName();
        storage.put(key, doctor);
        LoggerUtil.logInfo("Doctor saved: " + key);
        return doctor;
    }

    @Override
    public Optional<Doctor> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Doctor> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(String id) {
        storage.remove(id);
    }
}
