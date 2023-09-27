package ru.vsu.cs.galimov.tasks.business_logic;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Department> shopDepartments;

    public Shop(List<Department> shopDepartments) {
        this.shopDepartments = shopDepartments;
    }

    public void showAllDepartmentProducts() {
        for (Department dep : this.shopDepartments) {
            dep.showProducts();
        }
    }

    public List<Department> findEmptyDepartment() {
        List<Department> emptyDeps = new ArrayList<>();

        for (Department dep : this.shopDepartments) {
            if (dep.isEmpty()) {
                emptyDeps.add(dep);
            }
        }
        return emptyDeps;
    }

    public List<Department> getShopDepartments() {
        return shopDepartments;
    }

    public void setShopDepartments(List<Department> shopDepartments) {
        this.shopDepartments = shopDepartments;
    }

    public void addDepartment(Department department) {
        this.shopDepartments.add(department);
    }

    public void removeDepartment(Department departmentToRemove) {
        this.shopDepartments.remove(departmentToRemove);
    }


}
