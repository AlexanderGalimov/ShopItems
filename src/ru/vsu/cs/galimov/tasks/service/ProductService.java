package ru.vsu.cs.galimov.tasks.service;

import ru.vsu.cs.galimov.tasks.model_objects.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    void deleteProduct(int id);

    Product findProductById(int id);

    void renewProduct(int id, Product product);

    List<Product> getAllProducts();

    List<Product> allProductInDepartment(int idDep);
}
