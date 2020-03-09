<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: miade
  Date: 09-03-2020
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oversigt</title>
</head>
<body>

    <h3>Vi har ${requestScope.counter} kunder.</h3>


    <h3>Oversigt over kunderne:</h3>
    <br>
    <c:forEach var="element" items="${requestScope.oversigt}">
        - ${element}
        <br>
        <br>
    </c:forEach>

    <br>
    <br>
    <br>
    <form action="LogOutServlet" method="post">
        <%-- <label for="fname">Skriv vare</label><br> --%>
        <%--<input type="text" id="fname" name="vareNavn"><br> --%>
        <input type="submit" value="Logout">
    </form>
    <br>
    <br>
    <br>
</body>
</html>
