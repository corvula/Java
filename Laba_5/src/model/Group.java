package model;

import java.util.Objects;

public class Group implements Comparable<Group> {
    private String groupName;
    private int year;
    private int studentsCount;

    public Group(String groupName, int year, int studentsCount) {
        this.groupName = groupName;
        this.year = year;
        this.studentsCount = studentsCount;
    }

    @Override
    public int compareTo(Group other) {
        return this.groupName.compareToIgnoreCase(other.groupName);
    }

    public static final java.util.Comparator<Group> BY_YEAR =
            (g1, g2) -> Integer.compare(g1.year, g2.year);

    public static final java.util.Comparator<Group> BY_STUDENTS_COUNT =
            (g1, g2) -> Integer.compare(g1.studentsCount, g2.studentsCount);

    public String getGroupName() { return groupName; }
    public int getYear() { return year; }
    public int getStudentsCount() { return studentsCount; }

    @Override
    public String toString() {
        return groupName + " (" + year + ", " + studentsCount + " students)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group g = (Group) o;
        return year == g.year && studentsCount == g.studentsCount &&
               Objects.equals(groupName, g.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, year, studentsCount);
    }
}
