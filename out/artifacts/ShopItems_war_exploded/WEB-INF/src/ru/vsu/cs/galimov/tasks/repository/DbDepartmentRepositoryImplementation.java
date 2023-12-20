package ru.vsu.cs.galimov.tasks.repository;

import ru.vsu.cs.galimov.tasks.connection.ConnectionManager;
import ru.vsu.cs.galimov.tasks.model_objects.Department;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbDepartmentRepositoryImplementation implements DepartmentRepository {
    private static final ConnectionManager manager = ConnectionManager.getInstance();
    private static DbDepartmentRepositoryImplementation INSTANCE;

    public static DbDepartmentRepositoryImplementation getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new DbDepartmentRepositoryImplementation();
        }
        return INSTANCE;
    }

    @Override
    public void add(Department object) {
        try {
            if (object.getId() != null) {
                manager.executeUpdate("INSERT INTO department (idDepartment, name, workingHours) values " + "(" + object.getId() + ", " + "'" + object.getName() + "'" + ", " + "'" + object.getWorkingHours() + "'" + ")");
            } else {
                manager.executeUpdate("INSERT INTO department (name, workingHours) values " + "('" + object.getName() + "'" + ", " + "'" + object.getWorkingHours() + "'" + ")");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        try {
            manager.executeUpdate("DELETE FROM department WHERE idDepartment=" + id + ";");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Department findItemById(int id) throws IllegalArgumentException {
        try {
            ResultSet rs = manager.executeSelect("SELECT * FROM department WHERE idDepartment=" + id);
            rs.next();
            Department department = parseResultSetToDepartment(rs);
            rs.close();
            return department;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Department> findAllItems() {
        List<Department> departments = new ArrayList<>();
        try {
            ResultSet rs = manager.executeSelect("SELECT * FROM department");
            while (rs.next()) {
                departments.add(parseResultSetToDepartment(rs));
            }
            rs.close();
            return departments;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void renew(int id, Department object) throws IllegalArgumentException {
        try {
            manager.executeUpdate("UPDATE department SET " + "idDepartment=" + id + ", name='" + object.getName() + "', workingHours='" + object.getWorkingHours() + "'" + "WHERE idDepartment=" + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Department parseResultSetToDepartment(ResultSet rs) {
        try {
            int idDepartment = rs.getInt(1);
            String name = rs.getString(2);
            String workingHours = rs.getString(3);
            return new Department(idDepartment, name, workingHours);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
