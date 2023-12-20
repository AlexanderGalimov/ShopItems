package ru.vsu.cs.galimov.tasks.repository;

import java.util.List;

public interface Repository<T> {
    void add(T object);

    void delete(int id) throws IllegalArgumentException;

    T findItemById(int id) throws IllegalArgumentException;

    List<T> findAllItems();

    void renew(int id, T object) throws IllegalArgumentException;
}
