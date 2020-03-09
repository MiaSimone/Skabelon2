<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        

        <h1>Hello ${sessionScope.email} </h1>



        You are now logged in as a EMPLOYEE of our wonderful site.

        <br>
        <br>
        <br>
        <form name="oversigt" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="oversigt">
            <input type="submit" value="Oversigt">
        </form>

        <br>
        <h4>New Employee:</h4>
        <form name="registerEmployee" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="registerEmployee">
            Email:<br>
            <input type="text" name="email">
            <br>
            Password:<br>
            <input type="password" name="password1">
            <br>
            Retype Password:<br>
            <input type="password" name="password2">
            <br>
            <input type="submit" value="Submit">
        </form>
        ${requestScope.message}
        <br>
        <br>
        <br>

        <h4>Delete user:</h4>
        <form name="delete" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="delete">
            Email:<br>
            <input type="text" name="email1">
            <br>
            Repeat Email:<br>
            <input type="text" name="email2">
            <br>
            <input type="submit" value="Submit">
        </form>
        ${requestScope.message}
        <br>
        <br>
        <h4>Update user password:</h4>
        <form name="change" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="change">
            Email:<br>
            <input type="text" name="email">
            <br>
            Password:<br>
            <input type="password" name="password">
            <br>
            New Password:<br>
            <input type="password" name="newPassword">
            <br>
            <input type="submit" value="Submit">
        </form>
        ${requestScope.update}
    <br>
    <br>
    <br>
        <form action="LogOutServlet" method="post">
            <input type="submit" value="Logout">
        </form>
    <br>
    </body>
</html>
