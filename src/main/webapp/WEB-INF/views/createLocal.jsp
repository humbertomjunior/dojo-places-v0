<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1>Cadastrar local</h1>

<br/>
<br/>

<form:form modelAttribute="placeDto" method="post" action="/places/register">

    <label>Nome:</label>
    <form:input path="name"/>

    <br/>
    <label>Codigo:</label>
    <form:input path="code"/>

    <br/>
    <label>Bairro:</label>
    <form:input path="neighbourhood"/>

    <br/>
    <label>Cidade:</label>
    <form:input path="city"/>

<%--    <form:errors path="name" cssStyle="color: red"/>--%>

    <br/>
    <br/>

    <form:button>Cadastrar</form:button>

</form:form>

<%--    <script src="/assets/js/locais/buscarLocal.js"></script>--%>
<%--</form:form>--%>