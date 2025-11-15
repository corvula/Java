package org.example.medical.repository;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    protected List<T> data = new ArrayList<>();
    public void add(T item) { data.add(item); }
    public List<T> getAll() { return data; }
}
