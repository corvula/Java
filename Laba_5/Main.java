import model.Student;
import model.Group;
import repository.StudentRepository;
import repository.GroupRepository;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepo = new StudentRepository();
        studentRepo.add(new Student("Alice", 20, 89.5));
        studentRepo.add(new Student("Bob", 22, 75.0));
        studentRepo.add(new Student("Charlie", 19, 95.0));

        System.out.println("\n--- Students (Original) ---");
        studentRepo.getAll().forEach(System.out::println);

        studentRepo.sortByIdentity("asc");
        studentRepo.sortByAge(true);
        studentRepo.sortByGrade(false);

        GroupRepository groupRepo = new GroupRepository();
        groupRepo.add(new Group("CS-101", 2024, 25));
        groupRepo.add(new Group("CS-102", 2023, 30));
        groupRepo.add(new Group("AI-201", 2024, 20));

        System.out.println("\n--- Groups (Original) ---");
        groupRepo.getAll().forEach(System.out::println);

        groupRepo.sortByIdentity("asc");
        groupRepo.sortByYear(false);
        groupRepo.sortByStudentsCount(true);
    }
}
