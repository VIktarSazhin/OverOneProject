<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>JSP User Example</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h1 class="text-center">User Manager Application</h1>
    <hr>
    <div class="container text-left">
        <a href="<%=request.getContextPath()%>/ServletDriver?command=select" class="btn btn-success">Start app</a>
    </div>
</div>


</body>
</html>