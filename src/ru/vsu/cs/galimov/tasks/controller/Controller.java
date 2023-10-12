package ru.vsu.cs.galimov.tasks.controller;

import ru.vsu.cs.galimov.tasks.logic.Logic;
import ru.vsu.cs.galimov.tasks.model_objects.Department;
import ru.vsu.cs.galimov.tasks.model_objects.Product;
import ru.vsu.cs.galimov.tasks.repository.InMemoryRepositoryDepartmentImplementation;
import ru.vsu.cs.galimov.tasks.repository.InMemoryRepositoryProductImplementation;
import ru.vsu.cs.galimov.tasks.service.DepartmentService;
import ru.vsu.cs.galimov.tasks.service.ProductService;

import java.util.List;

public class Controller implements DepartmentService, ProductService {
    private static Controller INSTANCE;
    private final InMemoryRepositoryProductImplementation products;
    private final InMemoryRepositoryDepartmentImplementation departments;

    private Controller() {
        products = new InMemoryRepositoryProductImplementation();
        departments = new InMemoryRepositoryDepartmentImplementation();
    }

    public static Controller getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();
        }
        return INSTANCE;
    }

    public boolean isInDepartment(int id) {
        for (Department department : getAllDepartments()) {
            if (id == department.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addProduct(Product product) {
        if (isInDepartment(product.getDepartmentId())) {
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
        if (isInDepartment(product.getDepartmentId())) {
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
        if (isInDepartment(idDep)) {
            return Logic.allProductInDepartment(idDep);
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
        if (isInDepartment(id)) {
            List<Product> prodToDel = getAllProducts();
            for (Product product : prodToDel) {
                if (product.getDepartmentId() == id) {
                    products.delete(product.getId());
                }
            }
            departments.delete(id);
        } else {
            throw new IllegalArgumentException("Dep isn't exist");
        }
    }

    @Override
    public Department findDepartmentById(int id) {
        return departments.findItemById(id);
    }

    @Override
    public void renewDepartment(int id, Department department) {
        if (isInDepartment(id)) {
            departments.renew(id, department);
        } else {
            throw new IllegalArgumentException("Dep isn't exist");
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        return departments.findAllItems();
    }

    @Override
    public List<Department> findEmptyDepartments() {
        return Logic.findEmptyDepartments();
    }
}
