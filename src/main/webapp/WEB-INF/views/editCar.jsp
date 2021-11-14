<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 13.11.2021
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="car" method="post" action="/cars/editsave">
    <form:hidden path="id" value="${car.id}"></form:hidden>
    Marka: <form:input path="brand"></form:input><br>
    Model: <form:input path="model"></form:input><br>
    Kolor: <form:input path="color"></form:input><br>
    Silnik: <form:input path="engine"></form:input><br>
    <input type="submit" value="Zapisz zmiany">
</form:form>
</body>
</html>
