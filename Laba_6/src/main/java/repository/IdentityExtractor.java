package repository;

@FunctionalInterface
public interface IdentityExtractor<T> {
    int getId(T entity);
}
