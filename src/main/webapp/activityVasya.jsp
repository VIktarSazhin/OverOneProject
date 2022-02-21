<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Activity of Vasily Sholkov</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<br>
<div class="row">
    <div class="container">
        <h3 class="text-center">Activities of Vasily Sholkov</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/ServletDriver?command=select" class="btn btn-secondary">List activity</a>
        </div>
        <p></p>
        <br>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Spend Time</th>
                <th scope="col">Activity</th>
                <th scope="col">Time to add activity</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="user" items="${listVasyaActivity}">
                <tr>
                    <td>
                        <c:out value="${user.userName}" />
                    </td>
                    <td>
                        <c:out value="${user.timeToSpend}" />
                    </td>
                    <td>
                        <c:out value="${user.activity}" />
                    </td>
                    <td>
                        <c:out value="${user.timeToAdd}" />
                    </td>
                    <td>
                        <a href="servletDriver?command=delete&id=<c:out value='${user.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
