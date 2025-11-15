package model;

import enums.Specialty;

public class Doctor {
    private int id;
    private String name;
    private Specialty specialty;

    public Doctor(int id, String name, Specialty specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return "Doctor{id=" + id + ", name='" + name + "', specialty=" + specialty + "}";
    }
}
