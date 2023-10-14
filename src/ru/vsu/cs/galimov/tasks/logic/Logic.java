package ru.vsu.cs.galimov.tasks.logic;

import ru.vsu.cs.galimov.tasks.model_objects.Department;
import ru.vsu.cs.galimov.tasks.model_objects.Product;
import ru.vsu.cs.galimov.tasks.service.ServiceDepartmentImplementation;
import ru.vsu.cs.galimov.tasks.service.ServiceProductImplementation;

import java.util.ArrayList;
import java.util.List;

public class Logic{
    private static final ServiceDepartmentImplementation serviceDepartmentImplementation = ServiceDepartmentImplementation.getINSTANCE();
    private static final ServiceProductImplementation serviceProductImplementation = ServiceProductImplementation.getINSTANCE();

    public static boolean isInDepartment(int id) {
        for (Department department : serviceDepartmentImplementation.getAll()) {
            if (id == department.getId()) {
                return true;
            }
        }
        return false;
    }

    public static List<Product> allProductInDepartment(int idDep) {
        List<Product> prods = new ArrayList<>();
        for (Product product : serviceProductImplementation.getAll()) {
            if (product.getDepartmentId() == idDep) {
                prods.add(product);
            }
        }
        return prods;
    }

    public static List<Department> findEmptyDepartments() {
        List<Department> emptyDeps = new ArrayList<>();
        for (Department department : serviceDepartmentImplementation.getAll()) {
            if (allProductInDepartment(department.getId()).size() == 0) {
                emptyDeps.add(department);
            }
        }
        return emptyDeps;
    }
}
