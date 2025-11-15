import config.ConfigLoader;
import models.Person;
import repository.GenericRepository;
import service.SerializerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        ConfigLoader config = new ConfigLoader("src/main/resources/config.properties");

        String jsonPath = config.get("json.path");
        String yamlPath = config.get("yaml.path");
        int testSize = config.getInt("test.size");

        logger.info("Конфігурація прочитана");

        GenericRepository<Person> repo = new GenericRepository<>();
        for (int i = 1; i <= testSize; i++) {
            repo.add(new Person("User" + i, 20 + i));
        }

        SerializerService serializer = new SerializerService();

        serializer.saveAsJson(jsonPath, repo.getAll());
        serializer.saveAsYaml(yamlPath, repo.getAll());

        GenericRepository<Person> repoJson = new GenericRepository<>();
        repoJson.setAll(serializer.loadJson(jsonPath, Person[].class));
        GenericRepository<Person> repoYaml = new GenericRepository<>();
        repoYaml.setAll(serializer.loadYaml(yamlPath, Person[].class));

        System.out.println("Original: " + repo);
        System.out.println("JSON:     " + repoJson);
        System.out.println("YAML:     " + repoYaml);

        System.out.println(repo.toString().equals(repoJson.toString()) ? "JSON OK" : "JSON ERROR");
        System.out.println(repo.toString().equals(repoYaml.toString()) ? "YAML OK" : "YAML ERROR");
    }
}
