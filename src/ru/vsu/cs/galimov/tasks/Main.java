package ru.vsu.cs.galimov.tasks;

import ru.vsu.cs.galimov.tasks.app.ConsoleApplication;

public class Main {

    // Взять задачу, пробовать писать
    // 1) остов приложения, бизнес логика, доменная часть, архитектура
    // данные хардкод, in memory хранилище, singleton,
    // ui консольный интерфейс, но не голое приложение
    // 2) та же задача, in memory переписывается, на бд
    // in memory -> database, желательно поменять один пакет
    // 3) переписать UI, servlet, в локалхосте показать работу с бд
    // 1-2 JAR tomcat
    // автоматы будут, 36 и больше
    // зачет без оценки
    // DI dependency injection
    // 2х фазные конструкторы, прокси
    // можно использовать библиотеку для поднятия синглтонов,прокси - reflections
    // jstl

    // 13. Товары в магазине.
    //Отдел: название, часы работы.
    //Товар: название, цена.
    //- Добавлять отдел/товары,
    //- удалять отдел/товары,
    //- редактировать отдел/товары.
    // Показывать товары в отделе, отделы без товаров, весь список товаров в магазине.

    public static void main(String[] args) {
        ConsoleApplication app = new ConsoleApplication();
        app.run();

//        ConnectionManager manager = ConnectionManager.getInstance();
//        manager.executeUpdate("INSERT INTO department (idDepartment, name, workingHours) values (2, 'abs', 'hours')");
//
//        DbDepartmentRepositoryImplementation rep = DbDepartmentRepositoryImplementation.getINSTANCE();
//        rep.add(new Department("dep1", "8.00 - 17.00"));
//        rep.add(new Department("dep2", "9.00 - 20.00"));
//        rep.add(new Department("dep3", "14.00 - 20.00"));
//
//        rep.renew(20, new Department(25, "Alex", "boba"));
//
//        DbProductRepositotyImplementation rep = DbProductRepositotyImplementation.getINSTANCE();
//        rep.add(new Product(2, "kvas", 50, 25));
//        rep.renew(2, new Product(2, "ne kvas", 90, 7));
    }
}
