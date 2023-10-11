package ru.vsu.cs.galimov.tasks.repository;

import ru.vsu.cs.galimov.tasks.generator.IdGenerator;
import ru.vsu.cs.galimov.tasks.model_objects.Product;

import java.util.ArrayList;
import java.util.List;

public class inMemoryRepositoryProductImplementation implements ProductRepository, IdGenerator {
    private final List<Product> products;
    private int currProdId = 0;

    public inMemoryRepositoryProductImplementation() {
        this.products = new ArrayList<>();
    }

    @Override
    public int generateId() {
        currProdId += 1;
        return currProdId;
    }

    @Override
    public void add(Product object) throws IllegalArgumentException{
        if (object.getId() == null) {
            object.setId(generateId());
        }
        products.add(object);
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return;
            }
        }
        throw new IllegalArgumentException("Product with transmitted ID " + id + " not exist");
    }

    @Override
    public Product findItemById(int id) throws IllegalArgumentException {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new IllegalArgumentException("Product with transmitted ID " + id + " not exist");
    }

    @Override
    public List<Product> findAllItems() {
        return new ArrayList<>(products);
    }

    @Override
    public void renew(int id, Product object) throws IllegalArgumentException {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                object.setId(id);
                products.set(i, object);
                return;
            }
        }
        throw new IllegalArgumentException("Product with transmitted ID to swap " + id + " not exist");
    }
}
