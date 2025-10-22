package model;

import exceptions.InvalidDataException;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws InvalidDataException {
        if (name == null || name.isEmpty()) {
            throw new InvalidDataException("Ім'я не може бути порожнім!");
        }
        if (age < 0 || age > 120) {
            throw new InvalidDataException("Вік некоректний: " + age);
        }
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
