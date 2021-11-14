<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 11.11.2021
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="add" action="/cars/save">
    Marka: <form:input path="brand"></form:input><br>
    Model: <form:input path="model"></form:input><br>
    Kolor: <form:input path="color"></form:input><br>
    Silnik: <form:input path="engine"></form:input><br>
    <input type="submit" value="Dodaj">
</form:form>
</body>
</html>
