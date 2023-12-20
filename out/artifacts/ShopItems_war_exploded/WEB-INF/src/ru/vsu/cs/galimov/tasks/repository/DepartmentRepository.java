package ru.vsu.cs.galimov.tasks.repository;

import ru.vsu.cs.galimov.tasks.model_objects.Department;

import java.util.List;

public interface DepartmentRepository extends Repository<Department> {
    @Override
    void add(Department object);

    @Override
    void delete(int id) throws IllegalArgumentException;

    @Override
    Department findItemById(int id) throws IllegalArgumentException;

    @Override
    List<Department> findAllItems();

    @Override
    void renew(int id, Department object) throws IllegalArgumentException;
}
