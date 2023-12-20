package ru.vsu.cs.galimov.tasks.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.vsu.cs.galimov.tasks.model_objects.Department;
import ru.vsu.cs.galimov.tasks.service.ServiceDepartmentImplementation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="DepartmentServlet",
        urlPatterns={
                "/department",
                "/department/edit",
                "/department/update",
                "/department/delete",
                "/department/new",
                "/department/getAll",
                "/department/add",
        })

public class DepartmentServlet extends HttpServlet {

    private final ServiceDepartmentImplementation serviceDepartmentImplementation;

    public DepartmentServlet() {
        this.serviceDepartmentImplementation = ServiceDepartmentImplementation.getINSTANCE();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/department/add" -> insertDepartment(request, response);
                case "/department/update" -> updateDepartment(request, response);
            }
        } catch(SQLException ex) {
            throw new ServletException();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath();

        try {
            switch (action) {
                case "/department/new" -> showNewForm(request, response);
                case "/department/delete" -> deleteDepartment(request, response);
                case "/department/edit" -> showEditForm(request, response);
                default -> listDepartments(request, response);
            }
        } catch(SQLException ex) {
            throw new ServletException();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/department/department-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Department department = serviceDepartmentImplementation.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/department/department-form.jsp");
        request.setAttribute("department", department);
        dispatcher.forward(request, response);
    }

    private void insertDepartment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String workingHours = request.getParameter("workingHours");
        serviceDepartmentImplementation.add(new Department(name, workingHours));
        response.sendRedirect("getAll");
    }

    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceDepartmentImplementation.delete(id);
        response.sendRedirect("getAll");
    }

    private void updateDepartment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String name = request.getParameter("name");
        String workingHours = request.getParameter("workingHours");
        serviceDepartmentImplementation.renew(id, new Department(name, workingHours));
        response.sendRedirect("getAll");
    }

    private void listDepartments(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        List<Department> departmentList = serviceDepartmentImplementation.getAll();

        request.setAttribute("listDepartments", departmentList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/department/department-list.jsp");
        dispatcher.forward(request, response);
    }

}
