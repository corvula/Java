import model.Student;
import org.junit.jupiter.api.Test;
import repository.StudentRepository;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    @Test
    public void testSortByAgeAscending() {
        StudentRepository repo = new StudentRepository();
        repo.add(new Student("A", 22, 85));
        repo.add(new Student("B", 19, 95));

        repo.sortByAge(true);

        assertEquals(19, repo.getAll().get(0).getAge());
    }

    @Test
    public void testSortByGradeDescending() {
        StudentRepository repo = new StudentRepository();
        repo.add(new Student("A", 20, 80));
        repo.add(new Student("B", 21, 90));

        repo.sortByGrade(false);

        assertEquals(90, repo.getAll().get(0).getGrade());
    }
}
