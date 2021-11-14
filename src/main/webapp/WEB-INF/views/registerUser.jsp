<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 12.11.2021
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="user" method="post" action="/user/save">
    Podaj imię: <form:input path="name"></form:input><br>
    Podaj nazwisko: <form:input path="surName"></form:input><br>
    Podaj email: <form:input path="username"></form:input><br>
    Podaj haslo: <form:password path="password"></form:password><br>
    <input type="submit" value="Zarejestruj">
</form:form>
</body>
</html>
