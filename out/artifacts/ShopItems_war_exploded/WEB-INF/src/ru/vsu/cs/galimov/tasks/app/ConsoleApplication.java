package ru.vsu.cs.galimov.tasks.app;

import ru.vsu.cs.galimov.tasks.command.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isRun = true;
    private static final List<Command> commands = new ArrayList<>();

    public ConsoleApplication() {
        commands.add(new PrintAllDepartments(scanner));
        commands.add(new PrintAllProducts(scanner));
        commands.add(new CreateProduct(scanner));
        commands.add(new CreateDepartment(scanner));
        commands.add(new UpdateProduct(scanner));
        commands.add(new UpdateDepartment(scanner));
        commands.add(new PrintEmptyDepartments(scanner));
        commands.add(new PrintAllProductInDepartment(scanner));
        commands.add(new DeleteDepartment(scanner));
        commands.add(new DeleteProduct(scanner));
        commands.add(new FindProductById(scanner));
        commands.add(new FindDepartmentById(scanner));
    }

    private void menu() {
        System.out.println("Меню");
//        System.out.println("""
//                (0) - Вывести список отделов
//                (1) - Вывести список продуктов
//                (2) - Создать продукт
//                (3) - Создать отдел
//                (4) - Редактировать продукт
//                (5) - Редактировать отдел
//                (6) - Вывести пустые отделы
//                (7) - Показать товары в отделе
//                (8) - Удалить отдел
//                (9) - Удалить продукт
//                (10) - Найти продукт по id""");
//                (11) - Найти отдел по id""");
//                (12) - Выход""");

        try {
            System.out.println("Choose command");
            for (int i = 0; i < commands.size(); i++) {
                System.out.println(i + " " + commands.get(i).getCommandName());
            }
            System.out.println("Exit: 12");

            int choice = scanner.nextInt();
            if (choice >= 0 && choice < commands.size()){
                System.out.println("Choice " + choice);
                commands.get(choice).runCommand();
            }
            else if(choice == commands.size() + 1){
                changeState();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("incorrect command");
        }
    }

    public void run() {
        while (isRun) {
            menu();
        }
    }

    private void changeState() {
        isRun = false;
    }

}
