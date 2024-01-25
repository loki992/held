<%--
  Created by IntelliJ IDEA.
  User: adrian
  Date: 19.12.2023
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>

<%--<a href="update?editId=${character.id}">Update this character</a>--%>
<%--<a href="delete?deleteId=${character.id}">Delete this character</a>--%>

id: ${character.id} </br>
name: ${character.name}</br>
surname: ${character.surname}</br>
player: ${owner.login}</br>
Stats: </br>
str: ${character.strength}   dex: ${character.dexterity}   pow: ${character.power} </br>
con: ${character.fitness}    looks: ${character.looks}     edu: ${character.education} </br>
phys: ${character.physique}  int: ${character.inteligence} mov: ${character.movement}
</body>
</html>
