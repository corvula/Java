package repository;

import java.util.*;
import java.util.logging.Logger;

public class GenericRepository<T> {
    private final List<T> items = new ArrayList<>();
    private final IdentityExtractor<T> identityExtractor;
    private static final Logger logger = Logger.getLogger(GenericRepository.class.getName());

    public GenericRepository(IdentityExtractor<T> identityExtractor) {
        this.identityExtractor = identityExtractor;
    }

    public void add(T item) {
        items.add(item);
        logger.info("Added: " + item);
    }

    public void remove(T item) {
        items.remove(item);
        logger.info("Removed: " + item);
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public Optional<T> findByIdentity(String identity) {
        return items.stream()
                .filter(i -> identityExtractor.getIdentity(i).equals(identity))
                .findFirst();
    }
}
