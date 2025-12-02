<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Listagem de locais</h1>

<table>
    <thead>
        <tr>
            <th class="column1">Id</th>
            <th class="column2">Nome</th>
            <th class="column3">Codigo</th>
            <th class="column5">Última atualização</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${places}" var="place">
            <tr>
                <td class="column1">${place.id()}</td>
                <td class="column2">${place.name()}</td>
                <td class="column3">${place.code()}</td>
                <td class="column4">${place.formatedCreatedDateTime()}</td>
                <c:choose>
                    <c:when test="${place.lastUpdateDateTimeInDays() > 0}">
                        <td class="column5">${place.lastUpdateDateTimeInDays()} dias atrás</td>
                    </c:when>
                    <c:otherwise>
                        <td class="column5">${place.lastUpdateDateTimeInHours()} horas atrás</td>
                    </c:otherwise>
                </c:choose>
                <td class="column6"><a href="places/edit/${place.id()}">editar</a></td>
                <td class="column7"><a href="places/remove/${place.id()}">remover</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<style>
    td, th {
        padding: 2px 4px;
        text-align: center;
    }
    table {
        border-collapse: separate;
        width: 50%;
    }
</style>
