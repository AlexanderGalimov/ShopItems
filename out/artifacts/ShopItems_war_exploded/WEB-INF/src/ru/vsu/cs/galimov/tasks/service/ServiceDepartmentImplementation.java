package ru.vsu.cs.galimov.tasks.service;

import ru.vsu.cs.galimov.tasks.logic.Logic;
import ru.vsu.cs.galimov.tasks.model_objects.Department;
import ru.vsu.cs.galimov.tasks.repository.DbDepartmentRepositoryImplementation;
import ru.vsu.cs.galimov.tasks.repository.DepartmentRepository;
import ru.vsu.cs.galimov.tasks.repository.InMemoryRepositoryDepartmentImplementation;

import java.util.List;

public class ServiceDepartmentImplementation implements DepartmentService{
    private static ServiceDepartmentImplementation INSTANCE;
    private final DepartmentRepository departments;

    public ServiceDepartmentImplementation() {
        //departments = InMemoryRepositoryDepartmentImplementation.getINSTANCE();
        this.departments = DbDepartmentRepositoryImplementation.getINSTANCE();
    }

    public static ServiceDepartmentImplementation getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ServiceDepartmentImplementation();
        }
        return INSTANCE;
    }

    @Override
    public void add(Department object) {
        departments.add(object);
    }

    @Override
    public void delete(int id) {
        if (Logic.isInDepartment(id)) {
            List<Department> depTodel = getAll();
            for (Department department : depTodel) {
                if (department.getId() == id) {
                    departments.delete(department.getId());
                }
            }
            departments.delete(id);
        } else {
            throw new IllegalArgumentException("Dep isn't exist");
        }
    }

    @Override
    public Department findById(int id) {
        if (Logic.isInDepartment(id)) {
            return departments.findItemById(id);
        } else {
            throw new IllegalArgumentException("Dep isn't exist");
        }
    }

    @Override
    public void renew(int id, Department object) {
        if (Logic.isInDepartment(id)) {
            departments.renew(id, object);
        } else {
            throw new IllegalArgumentException("Dep isn't exist");
        }
    }

    @Override
    public List<Department> getAll() {
        return departments.findAllItems();
    }

    public List<Department> findEmptyDepartments() {
        return Logic.findEmptyDepartments();
    }
}
