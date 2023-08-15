<%-- 
    Document   : index
    Created on : Aug 15, 2023, 4:50:59 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <ul> 
            <c:forEach items="${users}" var="u">
                <li>${u.id}</li>
            </c:forEach>
        </ul>
    </body>
</html>
