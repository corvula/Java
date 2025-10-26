
import model.Person;
import exceptions.InvalidDataException;
import util.LoggerUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = LoggerUtil.getLogger();

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        File file = new File("data.txt");

        logger.info("=== Початок виконання програми ===");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split(",");
                    String name = parts[0].trim();
                    int age = Integer.parseInt(parts[1].trim());
                    Person p = new Person(name, age);
                    people.add(p);
                    logger.info("Створено об'єкт: " + p);
                } catch (InvalidDataException e) {
                    logger.warning("Помилка валідації даних: " + e.getMessage());
                } catch (NumberFormatException e) {
                    logger.warning("Помилка перетворення числа у рядку: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            logger.severe("Файл не знайдено: " + e.getMessage());
        } catch (IOException e) {
            logger.severe("Помилка при зчитуванні файлу: " + e.getMessage());
        } finally {
            logger.info("=== Завершення читання файлу ===");
        }

        System.out.println("Список людей:");
        for (Person p : people) {
            System.out.println(p);
        }

        logger.info("=== Програма завершена успішно ===");
    }
}
