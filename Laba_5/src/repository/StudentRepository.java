package repository;

import model.Student;
import util.LoggerUtil;

import java.util.Comparator;

public class StudentRepository extends GenericRepository<Student> {

    public void sortByAge(boolean ascending) {
        data.sort(ascending ? Student.BY_AGE : Student.BY_AGE.reversed());
        LoggerUtil.log("Sorted by age (" + (ascending ? "asc" : "desc") + ")");
    }

    public void sortByGrade(boolean ascending) {
        Comparator<Student> comparator = ascending ?
                Student.BY_GRADE : Student.BY_GRADE.reversed();
        data.sort(comparator);
        LoggerUtil.log("Sorted by grade (" + (ascending ? "asc" : "desc") + ")");
    }
}
