<%--
  Created by IntelliJ IDEA.
  User: gmavi
  Date: 05/01/2025
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/Admin?action=gerirCarro">
    <label>Matricula:</label>
    <input type="text" name="matricula" />

    <label>Marca:</label>
    <input type="text" name="marca" />

    <label>Modelo:</label>
    <input type="text" name="modelo" />

    <label>Cor:</label>
    <input type="text" name="cor" />

    <label>Media:</label>
    <input type="text" name="media" />
    <!-- Se for binário, precisa de <input type="file"> e multipart request -->

    <label>Tipo:</label>
    <input type="text" name="tipo" />

    <button type="submit">Gravar</button>
</form>

</body>
</html>
