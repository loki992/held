<%--
  Created by IntelliJ IDEA.
  User: adrian
  Date: 16.12.2023
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New User</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>

    <form method="post">
        <input type="text" placeholder="Username" name="username">
        <input type="text" placeholder="Password" name="pass">
        <input type="submit" value="Login">
    </form>
</body>
</html>
