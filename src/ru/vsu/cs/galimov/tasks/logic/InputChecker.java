package ru.vsu.cs.galimov.tasks.logic;

import ru.vsu.cs.galimov.tasks.controller.Controller;
import ru.vsu.cs.galimov.tasks.model_objects.Department;

public class InputChecker {
    Controller controller = Controller.getINSTANCE();

    public boolean isInDepartment(int id) {
        for (Department department : controller.getAllDepartments()) {
            if (id == department.getId()) {
                return true;
            }
        }
        return false;
    }
}
