package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.controller.Controller;
import ru.vsu.cs.galimov.tasks.model_objects.Product;

import java.util.List;
import java.util.Scanner;

public class PrintAllProducts extends Command{
    public PrintAllProducts(Scanner scanner, Controller controller) {
        super(scanner, controller);
    }

    @Override
    public void runCommand() {
        List<Product> products = controller.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public String getCommandName() {
        return "PrintAllProducts";
    }
}
