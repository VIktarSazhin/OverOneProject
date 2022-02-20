<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>User Activity</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<br>
<div class="row">
    <div class="container">
        <h3 class="text-center">List of users activities</h3>
        <hr>
        <div class="container text-center">
            <a href="<%=request.getContextPath()%>/ServletDriver?command=AnnaListActivity" class="btn btn-danger">Hanna Zenko</a>
            <a href="<%=request.getContextPath()%>/ActivityViktorSazhin" class="btn btn-danger">Viktor Sazhin</a>
            <a href="<%=request.getContextPath()%>/sendJson" class="btn btn-danger">Alex Frost</a>
            <a href="<%=request.getContextPath()%>/sendJson" class="btn btn-danger">Vasili Sholkov</a>
            <a href="<%=request.getContextPath()%>/sendJson" class="btn btn-danger">Sergey Peretyagin</a>
            <a href="<%=request.getContextPath()%>/sendJson" class="btn btn-danger">Rauan Maksutov</a>
        </div>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/addActivityForm.jsp" class="btn btn-primary">Add new activity</a>
        </div>

        <table class="table table-bordered">
            <thead>
            <tr>
                <th>User Name</th>
                <th>Spend Time</th>
                <th>Activities</th>
            </thead>
            <tbody>
            <c:forEach var="user" items="${listUser}">
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
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
