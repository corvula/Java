package model;

public class Group implements Comparable<Group> {
    private String groupName;
    private int studentsCount;

    public Group(String groupName, int studentsCount) {
        this.groupName = groupName;
        this.studentsCount = studentsCount;
    }

    public String getGroupName() { return groupName; }
    public int getStudentsCount() { return studentsCount; }

    @Override
    public int compareTo(Group other) {
        return this.groupName.compareToIgnoreCase(other.groupName);
    }

    @Override
    public String toString() {
        return String.format("%s (students: %d)", groupName, studentsCount);
    }
}
