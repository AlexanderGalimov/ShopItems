package ru.vsu.cs.galimov.tasks.service;

import ru.vsu.cs.galimov.tasks.model_objects.Department;

import java.util.List;

public interface DepartmentService {
    void addDepartment(Department department);

    void deleteDepartment(int id);

    Department findDepartmentById(int id);

    void renewDepartment(int id, Department department);

    List<Department> getAllDepartments();

    List<Department> findEmptyDepartments();

}
