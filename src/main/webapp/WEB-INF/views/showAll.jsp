<%--
  Created by IntelliJ IDEA.
  User: adrian
  Date: 18.12.2023
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>All Characters</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>

<c:forEach items="${characters}" var="character">
    <p>
        ${character.id}: ${character.name} ${character.surname} <a href="show?id=${character.id}">Show character sheet</a> <a href="update?id=${character.id}">Update</a>  <a href="delete?id=${character.id}&sure=no">Delete</a>
    </p>
</c:forEach>




</body>
</html>
