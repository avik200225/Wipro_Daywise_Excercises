<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>List of Indian Cities</title></head>
<body>
    <h2>Cities in India:</h2>
    <ul>
        <c:forEach var="city" items="${cities}">
            <li>${city.name}</li>
        </c:forEach>
    </ul>
</body>
</html>
