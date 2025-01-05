<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmação de Reserva</title>
</head>
<body>
<h1>Confirmação de Reserva</h1>

<c:if test="${not empty mensagemSucesso}">
    <p style="color: green;">${mensagemSucesso}</p>
</c:if>

<p>Custo Previsto: ${custoPrevisto} EUR</p>

<form method="post" action="/Cliente?action=aplicarDesconto">
    <label for="codigoDesconto">Código de Desconto:</label>
    <input type="text" name="codigoDesconto" id="codigoDesconto">
    <button type="submit">Aplicar Desconto</button>
</form>

<a href="/Cliente">Voltar</a>
</body>
</html>

