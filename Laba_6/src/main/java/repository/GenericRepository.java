package repository;

import java.util.*;
import java.util.logging.Logger;

public class GenericRepository<T> {

    private final Map<Integer, T> storage = new HashMap<>();
    private final IdentityExtractor<T> idExtractor;

    private static final Logger logger = Logger.getLogger(GenericRepository.class.getName());

    public GenericRepository(IdentityExtractor<T> extractor) {
        this.idExtractor = extractor;
    }

    public void save(T entity) {
        int id = idExtractor.getId(entity);
        logger.info("Saving entity with id: " + id);
        storage.put(id, entity);
    }

    public T findById(int id) {
        logger.info("Finding entity by id: " + id);
        return storage.get(id);
    }

    public List<T> findAll() {
        logger.info("Finding all entities");
        return new ArrayList<>(storage.values());
    }

    public void delete(int id) {
        logger.info("Deleting entity id: " + id);
        storage.remove(id);
    }
}
