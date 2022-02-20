<%@ page import="service.TestToSendJson" %>
<%@ page import="service.UserServiceImpl" %>
<%@ page import="dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: savit
  Date: 17.02.2022
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<p>
    <% UserServiceImpl userService = new UserServiceImpl(new UserDao()); %>
    <% String json = userService.getJSON(); %>
    <%= json%>
</p>

</body>
</html>
