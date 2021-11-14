<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 13.11.2021
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Admin panel :<br><br><br><br>

<a href='<c:url value="/cars/add"/>'>Dodaj auto</a><br>
<a href='<c:url value="/cars/list"/>'>Lista aut</a><br>
</body>
</html>
