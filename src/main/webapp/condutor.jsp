<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ola</h1>
<c:forEach items="${aluguerList}" var="a">
    <p>ID = ${a.ID_Aluguer},
        Início = ${a.inicio},
        Fim = ${a.fim},
        Matricula = ${a.matricula}
    </p>
</c:forEach>
</body>
</html>
