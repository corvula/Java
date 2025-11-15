import models.Person;
import org.junit.jupiter.api.Test;
import repository.GenericRepository;
import service.SerializerService;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SerializerTests {

    @Test
    void testJsonSerialization() {
        SerializerService s = new SerializerService();
        String path = "test.json";

        List<Person> data = List.of(new Person("A", 10));

        s.saveAsJson(path, data);
        List<Person> restored = s.loadJson(path, Person[].class);

        assertEquals(data.get(0).getName(), restored.get(0).getName());
        new File(path).delete();
    }

    @Test
    void testYamlSerialization() {
        SerializerService s = new SerializerService();
        String path = "test.yaml";

        List<Person> data = List.of(new Person("B", 20));

        s.saveAsYaml(path, data);
        List<Person> restored = s.loadYaml(path, Person[].class);

        assertEquals(data.get(0).getAge(), restored.get(0).getAge());
        new File(path).delete();
    }
}
