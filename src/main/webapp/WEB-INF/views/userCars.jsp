<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 13.11.2021
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/mycars" method="post">
    <table>
        <tr>
            <th>Marka</th>
            <th>Model</th>
            <th>Kolor</th>
            <th>Silnik</th>
        </tr>
        <c:forEach items="${myCars}" var="car">
            <tr>
                <td>${car.brand}</td>
                <td>${car.model}</td>
                <td>${car.color}</td>
                <td>${car.engine}</td>
                <td><a href='<c:url value="/cars/returncar?id=${car.id}"></c:url>'>Zwróć</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
