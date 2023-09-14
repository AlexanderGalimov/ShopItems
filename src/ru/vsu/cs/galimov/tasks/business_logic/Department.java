package ru.vsu.cs.galimov.tasks.business_logic;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private final String name;
    private final List<Double> workingHours;
    private final List<Product> productsInStock = new ArrayList<>();

    public Department(String name, List<Double> workingHours) {
        this.name = name;
        this.workingHours = workingHours;
    }

    private void addProduct(Product product) {
        productsInStock.add(product);
    }

    public String getName() {
        return name;
    }

    public List<Double> getWorkingHours() {
        return workingHours;
    }

    public List<Product> getProductsInStock() {
        return productsInStock;
    }
}
