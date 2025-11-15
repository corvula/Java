package org.example.medical;

import org.example.medical.exception.InvalidDataException;
import org.example.medical.model.*;
import org.example.medical.repository.*;
import org.example.medical.util.LoggerUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LoggerUtil.logInfo("Start");

        PatientRepository patientRepo = new PatientRepository();
        DoctorRepository doctorRepo = new DoctorRepository();

        try {
            Patient p = new Patient("Anna","Koval","PT001", LocalDate.of(1999,5,12));
            patientRepo.add(p);
            LoggerUtil.logInfo("Valid patient added");
        } catch (InvalidDataException e) {
            LoggerUtil.logError(e.getMessage());
        }

        try {
            Patient p = new Patient(""," ","", LocalDate.of(2030,1,1));
            patientRepo.add(p);
        } catch (InvalidDataException e) {
            LoggerUtil.logError(e.getMessage());
        }

        try {
            Doctor d = new Doctor("Taras","Melnyk",Specialty.CARDIOLOGIST);
            doctorRepo.add(d);
            LoggerUtil.logInfo("Valid doctor added");
        } catch (InvalidDataException e) {
            LoggerUtil.logError(e.getMessage());
        }

        try {
            Doctor d = new Doctor("","",null);
            doctorRepo.add(d);
        } catch (InvalidDataException e) {
            LoggerUtil.logError(e.getMessage());
        }

        try {
            Appointment a = new Appointment(
                patientRepo.getById("PT001"),
                doctorRepo.getAll().get(0),
                LocalDateTime.now().plusDays(1)
            );
            LoggerUtil.logInfo("Valid appointment created");
        } catch (InvalidDataException e) {
            LoggerUtil.logError(e.getMessage());
        }

        try {
            Appointment a = new Appointment(null,null,LocalDateTime.now().minusDays(1));
        } catch (InvalidDataException e) {
            LoggerUtil.logError(e.getMessage());
        }

        LoggerUtil.logInfo("End");
    }
}
