package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.controller.Controller;
import ru.vsu.cs.galimov.tasks.model_objects.Product;

import java.util.Scanner;

public class PrintAllProductInDepartment extends Command{
    public PrintAllProductInDepartment(Scanner scanner, Controller controller) {
        super(scanner, controller);
    }

    @Override
    public void runCommand() {
        System.out.print("Enter dep id: ");
        int id = scanner.nextInt();

        for (Product product : controller.allProductInDepartment(id)) {
            System.out.println(product);
        }
    }

    @Override
    public String getCommandName() {
        return "PrintAllProductInDepartment";
    }
}
