package ru.vsu.cs.galimov.tasks.repository;

import ru.vsu.cs.galimov.tasks.model_objects.Product;

import java.util.List;

public interface ProductRepository extends Repository<Product> {
    @Override
    void add(Product object) throws IllegalArgumentException;

    @Override
    void delete(int id) throws IllegalArgumentException;

    @Override
    Product findItemById(int id) throws IllegalArgumentException;

    @Override
    List<Product> findAllItems();

    @Override
    void renew(int id, Product object) throws IllegalArgumentException;
}
