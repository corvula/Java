package repository;

import model.Group;
import util.LoggerUtil;

import java.util.Comparator;

public class GroupRepository extends GenericRepository<Group> {

    public void sortByYear(boolean ascending) {
        Comparator<Group> comparator = ascending ? Group.BY_YEAR : Group.BY_YEAR.reversed();
        data.sort(comparator);
        LoggerUtil.log("Sorted by year (" + (ascending ? "asc" : "desc") + ")");
    }

    public void sortByStudentsCount(boolean ascending) {
        Comparator<Group> comparator = ascending ? Group.BY_STUDENTS_COUNT : Group.BY_STUDENTS_COUNT.reversed();
        data.sort(comparator);
        LoggerUtil.log("Sorted by student count (" + (ascending ? "asc" : "desc") + ")");
    }
}
