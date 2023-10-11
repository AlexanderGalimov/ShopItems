package ru.vsu.cs.galimov.tasks.model_objects;

public class Product implements ShopStored {
    protected Integer id;
    protected String name;
    protected double price;
    protected int departmentId; // foreign

    public Product(String name, double price, int departmentId) {
        this.id = null;
        this.name = name;
        this.price = price;
        this.departmentId = departmentId;
    }

    public Product(Integer id, String name, double price, int departmentId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.departmentId = departmentId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", departmentId=" + departmentId +
                '}';
    }
}
