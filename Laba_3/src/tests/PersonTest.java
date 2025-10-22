package tests;

import model.Person;
import exceptions.InvalidDataException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testValidPerson() throws InvalidDataException {
        Person p = new Person("Оля", 22);
        assertEquals("Оля", p.getName());
        assertEquals(22, p.getAge());
    }

    @Test
    public void testInvalidAge() {
        assertThrows(InvalidDataException.class, () -> {
            new Person("Іван", -3);
        });
    }

    @Test
    public void testEmptyName() {
        assertThrows(InvalidDataException.class, () -> {
            new Person("", 25);
        });
    }
}
