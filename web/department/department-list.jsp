<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>ShopItems</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: orchid">
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/product/getAll"
                   class="nav-link">Products</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Departments</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/department/new" class="btn btn-success">Add
                New Department</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Working hours</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="department" items="${listDepartments}">

                <tr>
                    <td><c:out value="${department.getId()}" /></td>
                    <td><c:out value="${department.getName()}" /></td>
                    <td><c:out value="${department.getWorkingHours()}" /></td>
                    <td><a class="btn btn-primary" href="<%=request.getContextPath()%>/department/edit?id=<c:out value='${department.getId()}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a class="btn btn-danger"
                                href="<%=request.getContextPath()%>/department/delete?id=<c:out value='${department.getId()}' />">Delete</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>
</html>
