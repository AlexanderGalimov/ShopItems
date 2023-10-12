package ru.vsu.cs.galimov.tasks.logic;

import ru.vsu.cs.galimov.tasks.controller.Controller;
import ru.vsu.cs.galimov.tasks.model_objects.Department;
import ru.vsu.cs.galimov.tasks.model_objects.Product;

import java.util.ArrayList;
import java.util.List;

public class Logic {
    private static final Controller controller = Controller.getINSTANCE();

    public static List<Product> allProductInDepartment(int idDep) {
        List<Product> prods = new ArrayList<>();
        for (Product product : controller.getAllProducts()) {
            if (product.getDepartmentId() == idDep) {
                prods.add(product);
            }
        }
        return prods;
    }

    public static List<Department> findEmptyDepartments() {
        List<Department> emptyDeps = new ArrayList<>();
        for (Department department : controller.getAllDepartments()) {
            if (allProductInDepartment(department.getId()).size() == 0) {
                emptyDeps.add(department);
            }
        }
        return emptyDeps;
    }
}
