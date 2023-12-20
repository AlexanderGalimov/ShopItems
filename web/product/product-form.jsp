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
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${product != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${product == null}">
                <form action="add" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${product != null}">
                                Edit Product
                            </c:if>
                            <c:if test="${product == null}">
                                Add New Product
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${product != null}">
                        <input type="hidden" name="id" value="<c:out value='${product.getId()}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Product name</label> <input type="text"
                                                                value="<c:out value='${product.getName()}' />" class="form-control"
                                                                name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Product price</label> <input type="text"
                                                           value="<c:out value='${product.getPrice()}' />" class="form-control"
                                                           name="price" required="required">
                    </fieldset>


                    <select name="idDepartment">
                        <c:forEach items="${departmentList}" var="department">
                            <option value="${department.getId()}">${department.getName()}</option>
                        </c:forEach>
                    </select>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
