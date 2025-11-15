package model;

import enums.MedicationType;

public class Medication {
    private int id;
    private String name;
    private MedicationType type;

    public Medication(int id, String name, MedicationType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MedicationType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Medication{id=" + id + ", name='" + name + "', type=" + type + "}";
    }
}
