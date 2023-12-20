package ru.vsu.cs.galimov.tasks.service;

import java.util.List;

public interface Served<T> {
    void add(T object);

    void delete(int id);

    T findById(int id);

    void renew(int id, T object);

    List<T> getAll();


}
