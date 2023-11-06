<%-- 
    Document   : index
    Created on : 31 oct. 2023, 20:01:18
    Author     : Pedro Lazaro
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<!DOCTYPE html>
<html lang="es">
<c:choose>
    <c:when test="${requestScope.error != null}">
        <c:set var="nodisplay" value=""/>
    </c:when>
    <c:otherwise>
        <c:set var="nodisplay" value="nodisplay"/>
    </c:otherwise>
</c:choose>
<html>
    <head>
        <jsp:directive.include file="/INC/metas.inc"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/styles.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        <div class="login-box">
            <h2>Login</h2>
        <form action="Login" method="post">
                <p id='${nodisplay}' class="error">${requestScope.error}</p><br>
                <div class="user-box">
                    <%-- Tambien se puede hacer con ${cookie.user.value} --%>
                    <input type="text" id="usuario" name="usuario" value='${cookie.user.value}'>
                    <label for="usuario">Username</label>
                </div>
                <div class="user-box">
                    <input type="password" name="password" id="password">
                    <label for="password">Password</label>
                </div>
                <div class="recordar">
                    <input type="checkbox" id="recordar" name="recordar">
                    <label for="recordar">Recordar</label><br><br>
                </div>
                <button type="submit" name="button" value="login">Login</button>
            </form>
        </div>
    </body>
</html>
