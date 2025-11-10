package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.LoggerUtil;

public class GenericRepository<T extends Comparable<T>> {
    protected List<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
        LoggerUtil.log("Added: " + item);
    }

    public List<T> getAll() {
        return new ArrayList<>(data);
    }

    public void sortByIdentity(String order) {
        if (order.equalsIgnoreCase("asc")) {
            Collections.sort(data);
        } else if (order.equalsIgnoreCase("desc")) {
            data.sort(Collections.reverseOrder());
        }
        LoggerUtil.log("Sorted by identity (" + order + ")");
    }
}
