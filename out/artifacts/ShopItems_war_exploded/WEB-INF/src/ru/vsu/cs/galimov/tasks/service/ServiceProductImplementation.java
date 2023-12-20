package ru.vsu.cs.galimov.tasks.service;

import ru.vsu.cs.galimov.tasks.logic.Logic;
import ru.vsu.cs.galimov.tasks.model_objects.Product;
import ru.vsu.cs.galimov.tasks.repository.DbProductRepositotyImplementation;
import ru.vsu.cs.galimov.tasks.repository.InMemoryRepositoryProductImplementation;
import ru.vsu.cs.galimov.tasks.repository.ProductRepository;

import java.util.List;

public class ServiceProductImplementation implements ProductService {
    private static ServiceProductImplementation INSTANCE;
    private final ProductRepository products;

    public ServiceProductImplementation() {
        //this.products = InMemoryRepositoryProductImplementation.getINSTANCE();
        this.products = DbProductRepositotyImplementation.getINSTANCE();
    }

    public static ServiceProductImplementation getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ServiceProductImplementation();
        }
        return INSTANCE;
    }

    @Override
    public void add(Product object) {
        if (Logic.isInDepartment(object.getDepartmentId())) {
            products.add(object);
        } else {
            throw new IllegalArgumentException("Product dep isn't exist");
        }
    }

    @Override
    public void delete(int id) {
        products.delete(id);
    }

    @Override
    public Product findById(int id) {
        return products.findItemById(id);
    }

    @Override
    public void renew(int id, Product object) {
        if (Logic.isInDepartment(object.getDepartmentId())) {
            products.renew(id, object);
        } else {
            throw new IllegalArgumentException("Product dep isn't exist");
        }
    }

    @Override
    public List<Product> getAll() {
        return products.findAllItems();
    }

    public List<Product> allProductInDepartment(int idDep) {
        if (Logic.isInDepartment(idDep)) {
            return Logic.allProductInDepartment(idDep);
        } else {
            throw new IllegalArgumentException("Product dep isn't exist");
        }
    }
}
