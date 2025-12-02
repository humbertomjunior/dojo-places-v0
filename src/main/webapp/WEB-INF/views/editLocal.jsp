<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1>Editar local</h1>

<br/>
<br/>

<form:form modelAttribute="editPlaceForm" method="post" action="/places/edit/${id}">

    <label>Nome:</label>
    <form:input path="name"/>
    <br/>
    <form:errors path="name" cssStyle="color: red"/>

    <br/>
    <label>Codigo:</label>
    <form:input path="code"/>
    <br/>
    <form:errors path="code" cssStyle="color: red"/>

    <br/>
    <label>Bairro:</label>
    <form:input path="neighbourhood"/>
    <br/>
    <form:errors path="neighbourhood" cssStyle="color: red"/>

    <br/>
    <label>Cidade:</label>
    <form:input path="city"/>
    <br/>
    <form:errors path="city" cssStyle="color: red"/>

    <br/>
    <br/>

    <form:button>Editar</form:button>

    <script src="/assets/js/locais/buscarLocal.js"></script>
</form:form>