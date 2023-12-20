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
         style="background-color: tomato">
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/department/getAll"
                   class="nav-link">Departments</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Products</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/product/new" class="btn btn-success">Add
                New Product</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>name</th>
                <th>price</th>
                <th>departmentId</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="product" items="${listProducts}">

                <tr>
                    <td><c:out value="${product.getId()}" /></td>
                    <td><c:out value="${product.getName()}" /></td>
                    <td><c:out value="${product.getPrice()}" /></td>
                    <td><c:out value="${product.getDepartmentId()}" /></td>
                    <td><a class="btn btn-primary" href="<%=request.getContextPath()%>/product/edit?id=<c:out value='${product.getId()}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a class="btn btn-danger"
                                href="<%=request.getContextPath()%>/product/delete?id=<c:out value='${product.getId()}' />">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>
</body>
</html>