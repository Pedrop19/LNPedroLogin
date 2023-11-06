<%-- 
    Document   : logeado
    Created on : 31 oct. 2023, 19:57:33
    Author     : Pedro Lazaro
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<!DOCTYPE html>
<html>
<html lang="es">

    <head>
        <jsp:directive.include file="/INC/metas.inc"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./CSS/styles.css" rel="stylesheet" type="text/css"/>
        <title>Admin Page</title>
    </head>
    <body>
        <form action="Logout" method="post">
            <div class="container">
            <h1>Bienvenido ${sessionScope.usuario}</h1>
                <p>Tu ultimo login fue: <c:out value="${requestScope.ultimoAcceso}" default="Es la primera vez que entras" /> </p>
                <p>Varias Opciones</p>
                <button type="submit" name="button" value="logout">Cerrar Sesion</button>
            </div>
        </form>
    </body>
</html>
