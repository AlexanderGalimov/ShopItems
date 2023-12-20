package ru.vsu.cs.galimov.tasks.service;

import ru.vsu.cs.galimov.tasks.model_objects.Product;

import java.util.List;

public interface ProductService extends Served<Product>{

    @Override
    void add(Product object);

    @Override
    void delete(int id);

    @Override
    Product findById(int id);

    @Override
    void renew(int id, Product object);

    @Override
    List<Product> getAll();

    List<Product> allProductInDepartment(int idDep);


}
