package ru.vsu.cs.galimov.tasks.controller;

import ru.vsu.cs.galimov.tasks.logic.InputChecker;
import ru.vsu.cs.galimov.tasks.logic.Logic;
import ru.vsu.cs.galimov.tasks.model_objects.Department;
import ru.vsu.cs.galimov.tasks.model_objects.Product;
import ru.vsu.cs.galimov.tasks.repository.inMemoryRepositoryDepartmentImplementation;
import ru.vsu.cs.galimov.tasks.repository.inMemoryRepositoryProductImplementation;
import ru.vsu.cs.galimov.tasks.service.DepartmentService;
import ru.vsu.cs.galimov.tasks.service.ProductService;

import java.util.List;

public class Controller implements DepartmentService, ProductService {
    private static Controller INSTANCE;
    private final inMemoryRepositoryProductImplementation products;
    private final inMemoryRepositoryDepartmentImplementation departments;
    private final Logic logic;
    private final InputChecker checker;

    private Controller() {
        logic = new Logic();
        checker = new InputChecker();
        products = new inMemoryRepositoryProductImplementation();
        departments = new inMemoryRepositoryDepartmentImplementation();
    }

    public static Controller getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();
        }
        return INSTANCE;
    }

    @Override
    public void addProduct(Product product) {
        if (checker.isInDepartment(product.getId())) {
            products.add(product);
        } else {
            throw new IllegalArgumentException("Product dep isn't exist");
        }
    }

    @Override
    public void deleteProduct(int id) {
        products.delete(id);
    }

    @Override
    public Product findProductById(int id) {
        return products.findItemById(id);
    }

    @Override
    public void renewProduct(int id, Product product) {
        if (checker.isInDepartment(id)) {
            products.renew(id, product);
        } else {
            throw new IllegalArgumentException("Product dep isn't exist");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return products.findAllItems();
    }

    @Override
    public List<Product> allProductInDepartment(int idDep) {
        if (checker.isInDepartment(idDep)) {
            return logic.allProductInDepartment(idDep);
        } else {
            throw new IllegalArgumentException("Product dep isn't exist");
        }
    }

    @Override
    public void addDepartment(Department department) {
        departments.add(department);
    }

    @Override
    public void deleteDepartment(int id) {
        List<Product> prodToDel = getAllProducts();
        for (Product product : prodToDel) {
            if (product.getDepartmentId() == id) {
                products.delete(product.getId());
            }
        }
        departments.delete(id);
    }

    @Override
    public Department findDepartmentById(int id) {
        return departments.findItemById(id);
    }

    @Override
    public void renewDepartment(int id, Department department) {
        if (checker.isInDepartment(id)) {
            departments.renew(id, department);
        } else {
            throw new IllegalArgumentException("Product dep isn't exist");
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        return departments.findAllItems();
    }

    @Override
    public List<Department> findEmptyDepartments() {
        return logic.findEmptyDepartments();
    }
}
