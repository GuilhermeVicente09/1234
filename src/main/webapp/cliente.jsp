<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cliente - Reserva de Veículo</title>
</head>
<body>
<h1>Cliente</h1>
<h2>Alugar Veiculo</h2>

<form method="post" action="/Cliente?action=reservarVeiculo">
    <!-- Campo para selecionar o tipo de veículo -->
    <label for="tipoVeiculo">Tipo de Veículo:</label>

    <select name="tipoVeiculo" id="tipoVeiculo" required>
        <c:forEach var="tipos" items="${tiposVeiculos}">
            <option>${tipos.descricao}</option>
        </c:forEach>
    </select>
    <br><br>

    <!-- Campo para selecionar o parque de estacionamento -->
    <label for="parqueLevantamento">Parque de Estacionamento:</label>
    <select name="parqueLevantamento" id="parqueLevantamento" required>
        <c:forEach var="parque" items="${parques}">
            <option value="${parque.coordenadas}">${parque.morada} - ${parque.localidade}</option>
        </c:forEach>
    </select>
    <br><br>

    <!-- Campo para selecionar o período de aluguer -->
    <label for="inicio">Data e Hora de Início:</label>
    <input type="datetime-local" name="inicio" id="inicio" required>
    <br><br>

    <label for="fim">Data e Hora de Fim:</label>
    <input type="datetime-local" name="fim" id="fim" required>
    <br><br>
    <br><br>

    <form method="post" action="/Cliente?action=reservarVeiculo">
        <!-- Campos do formulário -->
        <button type="submit">Reservar</button>
    </form>

</form>
</body>
</html>
