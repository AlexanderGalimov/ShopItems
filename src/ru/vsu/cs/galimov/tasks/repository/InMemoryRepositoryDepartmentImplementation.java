package ru.vsu.cs.galimov.tasks.repository;

import ru.vsu.cs.galimov.tasks.generator.IdGenerator;
import ru.vsu.cs.galimov.tasks.model_objects.Department;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepositoryDepartmentImplementation implements DepartmentRepository, IdGenerator {
    private static InMemoryRepositoryDepartmentImplementation INSTANCE;
    private final List<Department> deps;
    private int currentDepId = 0;

    public InMemoryRepositoryDepartmentImplementation() {
        this.deps = new ArrayList<>();
    }

    public static InMemoryRepositoryDepartmentImplementation getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryRepositoryDepartmentImplementation();
        }
        return INSTANCE;
    }

    @Override
    public int generateId() {
        currentDepId += 1;
        return currentDepId;
    }

    @Override
    public void add(Department object) {
        if (object.getId() == null) {
            object.setId(generateId());
        }
        deps.add(object);
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        for (Department dep : deps) {
            if (dep.getId() == id) {
                deps.remove(dep);
                return;
            }
        }
        throw new IllegalArgumentException("Department with transmitted ID " + id + " not exist");
    }

    @Override
    public Department findItemById(int id) throws IllegalArgumentException {
        for (Department dep : deps) {
            if (dep.getId() == id) {
                return dep;
            }
        }
        throw new IllegalArgumentException("Department with transmitted ID " + id + " not exist");
    }

    @Override
    public List<Department> findAllItems() {
        return new ArrayList<>(deps);
    }

    @Override
    public void renew(int id, Department newDep) throws IllegalArgumentException {
        for (int i = 0; i < deps.size(); i++) {
            if (deps.get(i).getId() == id) {
                newDep.setId(id);
                deps.set(i, newDep);
                return;
            }
        }
        throw new IllegalArgumentException("Department with transmitted ID to swap " + id + " not exist");
    }
}
