package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.model_objects.Product;
import ru.vsu.cs.galimov.tasks.service.ServiceProductImplementation;

import java.util.List;
import java.util.Scanner;

public class PrintAllProducts extends Command{
    protected final ServiceProductImplementation serviceProductImplementation;

    public PrintAllProducts(Scanner scanner) {
        super(scanner);
        serviceProductImplementation = ServiceProductImplementation.getINSTANCE();
    }

    @Override
    public void runCommand() {
        List<Product> products = serviceProductImplementation.getAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public String getCommandName() {
        return "PrintAllProducts";
    }
}
