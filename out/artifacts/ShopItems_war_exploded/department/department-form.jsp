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
            <li><a href="<%=request.getContextPath()%>/depatment/getAll"
                   class="nav-link">Products</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${department != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${department == null}">
                <form action="add" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${department != null}">
                                Edit Department
                            </c:if>
                            <c:if test="${department == null}">
                                Add New Department
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${department != null}">
                        <input type="hidden" name="id" value="<c:out value='${department.getId()}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Department Name</label> <input type="text"
                                                              value="<c:out value='${department.getName()}' />" class="form-control"
                                                              name="name" required="required">
                    </fieldset>
                        <fieldset class="form-group">
                            <label>Department working hours</label> <input type="text"
                                                                  value="<c:out value='${department.getWorkingHours()}' />" class="form-control"
                                                                  name="workingHours" required="required">
                        </fieldset>
                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>