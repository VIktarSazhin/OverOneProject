<%--
  Created by IntelliJ IDEA.
  User: savit
  Date: 12.02.2022
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>User Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta charset="UTF-8">
</head>

<body>

<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
                <c:if test="${user == null}">
                <form action="ServletDriver" method="post">
                    <input type="hidden" name="command" value="insert">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${user == null}">
                                Add new user activity
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                    </c:if>

                        <fieldset class="form-group">
                            <label>User Name</label>
                            <select class="form-control" id="exampleFormControlSelect1" name="user_name" required="required">
                                <option>Anna Zanko</option>
                                <option>Viktor Sazhin</option>
                                <option>Rauan Maksut</option>
                                <option>Alex Frost</option>
                                <option>Sergey Peretyagin</option>
                                <option>Vasily Sholkov</option>
                            </select>
                        </fieldset>

                    <fieldset class="form-group">
                        <label>Spend Time</label> <input type="text" value="<c:out value='${user.timeToSpend}' />" class="form-control" name="spend_time">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Activity</label> <input type="text" value="<c:out value='${user.activity}' />" class="form-control" name="activities">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>

</html>
