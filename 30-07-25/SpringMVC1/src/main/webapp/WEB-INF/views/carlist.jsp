<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Car List</title>
</head>
<body>
    <h2>Available Cars</h2>
    <ul>
        <c:forEach var="prod" items="${prodList}">
            <li>${prod}</li>
        </c:forEach>
    </ul>
</body>
</html>
