package repository;

import java.util.ArrayList;
import java.util.List;

public class GenericRepository<T> {

    private final List<T> data = new ArrayList<>();

    public void add(T obj) {
        data.add(obj);
    }

    public List<T> getAll() {
        return new ArrayList<>(data);
    }

    public void setAll(List<T> list) {
        data.clear();
        data.addAll(list);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
