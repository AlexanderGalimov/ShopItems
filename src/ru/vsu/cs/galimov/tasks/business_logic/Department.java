package ru.vsu.cs.galimov.tasks.business_logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Department {
    private final String name;
    private final List<Date> workingHours;
    private final List<Product> productsInStock = new ArrayList<>();

    public Department(String name, List<Date> workingHours) {
        this.name = name;
        this.workingHours = workingHours;
    }

    private void addProduct(Product product) {
        productsInStock.add(product);
    }

    private void removeProduct(Product product) {
        this.productsInStock.remove(product);
    }

    private void addDate(Date newDate) {
        this.workingHours.add(newDate);
    }

    private void changeDate(Date oldDate, Date newDate) {
        int index = this.workingHours.indexOf(oldDate);
        this.workingHours.set(index, newDate);
    }

    private void removeDate(Date dateToRemove){
        this.workingHours.remove(dateToRemove);
    }

    public void showProducts(){
        if (this.productsInStock.size() == 0){
            System.out.println("empty department");
            return;
        }

        for (Product prod: this.productsInStock) {
            System.out.println(prod);
        }
    }

    public boolean isEmpty(){
        return this.productsInStock.size() == 0;
    }

    public String getName() {
        return name;
    }

    public List<Date> getWorkingHours() {
        return workingHours;
    }

    public List<Product> getProductsInStock() {
        return productsInStock;
    }
}
