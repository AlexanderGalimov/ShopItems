package ru.vsu.cs.galimov.tasks.app;

import ru.vsu.cs.galimov.tasks.controller.Controller;
import ru.vsu.cs.galimov.tasks.model_objects.Department;
import ru.vsu.cs.galimov.tasks.model_objects.Product;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private static final Controller controller = Controller.getINSTANCE();
    private static final Scanner scanner = new Scanner(System.in);


    private static void menu() {
        System.out.println("Меню");
        System.out.println("""
                (1) - Вывести список отделов
                (2) - Вывести список продуктов
                (3) - Создать продукт
                (4) - Создать отдел
                (5) - Редактировать продукт
                (6) - Редактировать отдел
                (7) - Вывести пустые отделы
                (8) - Показать товары в отделе
                (9) - Выход""");
    }

    private void createProduct() {
        try {
            System.out.print("Введите название продукта: ");
            String name = scanner.nextLine();
            System.out.print("Введите цену: ");
            double price = scanner.nextDouble();
            System.out.print("Введите отдел: ");
            int idDepartment = scanner.nextInt();

            controller.addProduct(new Product(name, price, idDepartment));

        } catch (Exception exception) {
            System.out.println("Illegal argument");
        }
    }

    private void createDepartment() {
        try {
            System.out.print("Введите название: ");
            String name = scanner.nextLine();
            System.out.print("Введите время работы: ");
            String workingHours = scanner.next();
            // 31/12/1998
            controller.addDepartment(new Department(name, new SimpleDateFormat("dd/MM/yyyy").parse(workingHours)));

        } catch (Exception exception) {
            System.out.println("Illegal argument");
        }
    }

    private void printAllDepartments() {
        List<Department> deps = controller.getAllDepartments();
        for (Department dep : deps) {
            System.out.println(dep);
        }
    }

    private void printAllProducts() {
        List<Product> products = controller.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private void updateProduct() {
        printAllProducts();
        System.out.print("Введите айди продукта: ");
        int id = scanner.nextInt();
        System.out.print("Введите название продукта: ");
        String name = scanner.nextLine();
        System.out.print("Введите цену: ");
        double price = scanner.nextDouble();
        System.out.print("Введите отдел: ");
        int idDepartment = scanner.nextInt();

        controller.renewProduct(id, new Product(id, name, price, idDepartment));
    }

    private void updateDepartment() {
        try {
            printAllProducts();
            System.out.print("Введите айди отдела: ");
            int id = scanner.nextInt();
            System.out.print("Введите название отдела: ");
            String name = scanner.nextLine();
            System.out.print("Введите часы работы: ");
            String workingHours = scanner.next();
            // 31/12/1998
            controller.renewDepartment(id, new Department(id, name, new SimpleDateFormat("dd/MM/yyyy").parse(workingHours)));

        } catch (Exception exception) {
            System.out.println("Illegal argument");
        }
    }


    private void printEmptyDepartments() {
        for (Department department : controller.findEmptyDepartments()) {
            System.out.println(department);
        }
    }

    private void printDepartmentProducts() {
        System.out.print("Введите айди отдела: ");
        int id = scanner.nextInt();

        for (Product product : controller.allProductInDepartment(id)) {
            System.out.println(product);
        }
    }

}
