package repository;

@FunctionalInterface
public interface IdentityExtractor<T> {
    String getIdentity(T object);
}
