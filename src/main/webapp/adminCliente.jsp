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
<form method="post" action="/Admin?action=gerirCliente">
    <label>NIF:</label>
    <input type="text" name="nif" />

    <label>Nome:</label>
    <input type="text" name="nome" />

    <label>Contacto:</label>
    <input type="text" name="contacto" />

    <label>Morada:</label>
    <input type="text" name="morada" />

    <label>Preferências Linguísticas:</label>
    <input type="text" name="preferenciasLinguisticas" />

    <button type="submit">Gravar</button>
</form>

</body>
</html>
