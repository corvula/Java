package model;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    public static final java.util.Comparator<Student> BY_AGE =
            (s1, s2) -> Integer.compare(s1.age, s2.age);

    public static final java.util.Comparator<Student> BY_GRADE =
            java.util.Comparator.comparingDouble(Student::getGrade);

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }

    @Override
    public String toString() {
        return name + " (" + age + " y.o., " + grade + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return age == s.age && Double.compare(s.grade, grade) == 0 && Objects.equals(name, s.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, grade);
    }
}
