<%@ page import="service.TestToSendJson" %><%--
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
    <% String json = TestToSendJson.getJsonToString(); %>
    <%= json%>
</p>

</body>
</html>
