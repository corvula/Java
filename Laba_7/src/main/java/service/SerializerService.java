package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import exceptions.DataSerializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SerializerService {

    private static final Logger logger = LoggerFactory.getLogger(SerializerService.class);

    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final YAMLMapper yamlMapper = new YAMLMapper();

    public <T> void saveAsJson(String path, List<T> data) {
        try {
            jsonMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), data);
            logger.info("JSON успішно збережено: " + path);
        } catch (IOException e) {
            logger.error("Помилка збереження JSON", e);
            throw new DataSerializationException("JSON save failed", e);
        }
    }

    public <T> List<T> loadJson(String path, Class<T[]> clazz) {
        try {
            T[] arr = jsonMapper.readValue(new File(path), clazz);
            logger.info("JSON прочитано: " + path);
            return List.of(arr);
        } catch (IOException e) {
            logger.error("Помилка читання JSON", e);
            throw new DataSerializationException("JSON load failed", e);
        }
    }

    public <T> void saveAsYaml(String path, List<T> data) {
        try {
            yamlMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), data);
            logger.info("YAML успішно збережено: " + path);
        } catch (IOException e) {
            logger.error("Помилка збереження YAML", e);
            throw new DataSerializationException("YAML save failed", e);
        }
    }

    public <T> List<T> loadYaml(String path, Class<T[]> clazz) {
        try {
            T[] arr = yamlMapper.readValue(new File(path), clazz);
            logger.info("YAML прочитано: " + path);
            return List.of(arr);
        } catch (IOException e) {
            logger.error("Помилка читання YAML", e);
            throw new DataSerializationException("YAML load failed", e);
        }
    }
}
