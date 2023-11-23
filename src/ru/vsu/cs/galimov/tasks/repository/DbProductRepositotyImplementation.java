package ru.vsu.cs.galimov.tasks.repository;

import ru.vsu.cs.galimov.tasks.connection.ConnectionManager;
import ru.vsu.cs.galimov.tasks.model_objects.Product;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbProductRepositotyImplementation implements ProductRepository {
    private static final ConnectionManager manager = ConnectionManager.getInstance();
    private static DbProductRepositotyImplementation INSTANCE;

    public static DbProductRepositotyImplementation getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new DbProductRepositotyImplementation();
        }
        return INSTANCE;
    }

    @Override
    public void add(Product object) throws IllegalArgumentException {
        try {
            if (object.getId() != null) {
                manager.executeUpdate("INSERT INTO product (idProduct, name, price, idDepartment) values " + "(" + object.getId() + ", " + "'" + object.getName() + "'" + ", " + "'" + object.getPrice() + "', " + object.getDepartmentId() + ")");
            } else {
                manager.executeUpdate("INSERT INTO product (name, price, idDepartment) values " + "(" + "'" + object.getName() + "'" + ", " + "'" + object.getPrice() + "', " + object.getDepartmentId() + ")");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        try {
            manager.executeUpdate("DELETE FROM product WHERE idProduct=" + id + ";");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Product findItemById(int id) throws IllegalArgumentException {
        try {
            ResultSet rs = manager.executeSelect("SELECT * FROM product WHERE idProduct=" + id);
            rs.next();
            Product product = parseResultSetToProduct(rs);
            rs.close();
            return product;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Product> findAllItems() {
        List<Product> products = new ArrayList<>();
        try {
            ResultSet rs = manager.executeSelect("SELECT * FROM product");
            while (rs.next()) {
                products.add(parseResultSetToProduct(rs));
            }
            rs.close();
            return products;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void renew(int id, Product object) throws IllegalArgumentException {
        try {
            manager.executeUpdate("UPDATE product SET " + "idProduct=" + object.getId() + ", name='" + object.getName() + "', price=" + object.getPrice() + ", idDepartment=" + object.getDepartmentId() + " " + "WHERE idProduct=" + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Product parseResultSetToProduct(ResultSet rs) {
        try {
            int idProduct = rs.getInt(1);
            String name = rs.getString(2);
            double price = rs.getDouble(3);
            int idDepartment = rs.getInt(4);
            return new Product(idProduct, name, price, idDepartment);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
