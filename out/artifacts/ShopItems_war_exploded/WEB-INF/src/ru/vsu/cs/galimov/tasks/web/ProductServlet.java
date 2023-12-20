package ru.vsu.cs.galimov.tasks.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.vsu.cs.galimov.tasks.model_objects.Department;
import ru.vsu.cs.galimov.tasks.model_objects.Product;
import ru.vsu.cs.galimov.tasks.service.ServiceDepartmentImplementation;
import ru.vsu.cs.galimov.tasks.service.ServiceProductImplementation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="ProductServlet", urlPatterns={
        "/product",
        "/product/edit",
        "/product/update",
        "/product/delete",
        "/product/new",
        "/product/getAll",
        "/product/add",
})

public class ProductServlet extends HttpServlet {

    private ServiceProductImplementation serviceProductImplementation;
    private ServiceDepartmentImplementation serviceDepartmentImplementation;

    public ProductServlet() {
        this.serviceProductImplementation = ServiceProductImplementation.getINSTANCE();
        this.serviceDepartmentImplementation = ServiceDepartmentImplementation.getINSTANCE();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath();

        try {
            switch (action) {
                case "/product/add" -> insertProduct(request, response);
                case "/product/update" -> updateProduct(request, response);
            }
        } catch(SQLException ex) {
            throw new ServletException();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath();

        try {
            switch (action) {
                case "/product/new" -> showNewForm(request, response);
                case "/product/delete" -> deleteProduct(request, response);
                case "/product/edit" -> showEditForm(request, response);
                default -> listProducts(request, response);
            }
        } catch(SQLException ex) {
            throw new ServletException();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        List<Department> departments = serviceDepartmentImplementation.getAll();
        request.setAttribute("departmentList", departments);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/product-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = serviceProductImplementation.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/product-form.jsp");

        request.setAttribute("product", product);

        List<Department> departments = serviceDepartmentImplementation.getAll();
        request.setAttribute("departmentList", departments);

        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int idDepartment = Integer.parseInt(request.getParameter("idDepartment"));

        serviceProductImplementation.add(new Product(name, price, idDepartment));

        response.sendRedirect("getAll");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceProductImplementation.delete(id);
        response.sendRedirect("getAll");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int idDepartment = Integer.parseInt(request.getParameter("idDepartment"));

        serviceProductImplementation.renew(id, new Product(name, price, idDepartment));

        response.sendRedirect("getAll");
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> productsList = serviceProductImplementation.getAll();
        request.setAttribute("listProducts", productsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/product-list.jsp");
        dispatcher.forward(request, response);
    }

}