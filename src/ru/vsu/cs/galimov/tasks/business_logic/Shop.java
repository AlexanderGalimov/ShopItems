package ru.vsu.cs.galimov.tasks.business_logic;

import java.util.List;

public class Shop {
    private List<Department> shopDepartments;

    public Shop(List<Department> shopDepartments) {
        this.shopDepartments = shopDepartments;
    }

    public List<Department> getShopDepartments() {
        return shopDepartments;
    }

    public void setShopDepartments(List<Department> shopDepartments) {
        this.shopDepartments = shopDepartments;
    }
}
