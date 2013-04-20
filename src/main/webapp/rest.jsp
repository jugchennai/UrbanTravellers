<%-- 
    Document   : rest
    Created on : Apr 20, 2013, 8:54:06 PM
    Author     : prasannakumar
--%>

<%@page import="in.jugchennai.urbantravellers.game.GameCache"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            GameCache.getInstance().getBoard().clearPlayers();
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>
