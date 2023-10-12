package ru.vsu.cs.galimov.tasks.app;

import ru.vsu.cs.galimov.tasks.command.*;
import ru.vsu.cs.galimov.tasks.controller.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private static final Controller controller = Controller.getINSTANCE();
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isRun = true;
    private static final List<Command> commands = new ArrayList<>();

    public ConsoleApplication() {
        commands.add(new PrintAllDepartments(scanner, controller));
        commands.add(new PrintAllProducts(scanner, controller));
        commands.add(new CreateProduct(scanner, controller));
        commands.add(new CreateDepartment(scanner, controller));
        commands.add(new UpdateProduct(scanner, controller));
        commands.add(new UpdateDepartment(scanner, controller));
        commands.add(new PrintEmptyDepartments(scanner, controller));
        commands.add(new PrintAllProductInDepartment(scanner, controller));
        commands.add(new DeleteDepartment(scanner, controller));
        commands.add(new DeleteProduct(scanner, controller));
    }

    private void menu() {
        System.out.println("Меню");
//        System.out.println("""
//                (1) - Вывести список отделов
//                (2) - Вывести список продуктов
//                (3) - Создать продукт
//                (4) - Создать отдел
//                (5) - Редактировать продукт
//                (6) - Редактировать отдел
//                (7) - Вывести пустые отделы
//                (8) - Показать товары в отделе
//                (9) - Удалить отдел
//                (10) - Удалить продукт
//                (11) - Выход""");

        try {
            System.out.println("Choose command");
            for (int i = 0; i < commands.size(); i++) {
                System.out.println(i + " " + commands.get(i).getCommandName());
            }
            System.out.println("Exit: 11");

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
