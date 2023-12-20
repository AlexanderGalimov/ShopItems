package ru.vsu.cs.galimov.tasks.service;

import ru.vsu.cs.galimov.tasks.model_objects.Department;

import java.util.List;

public interface DepartmentService extends Served<Department>{
    @Override
    void add(Department object);

    @Override
    void delete(int id);

    @Override
    Department findById(int id);

    @Override
    void renew(int id, Department object);

    @Override
    List<Department> getAll();

    List<Department> findEmptyDepartments();

}
