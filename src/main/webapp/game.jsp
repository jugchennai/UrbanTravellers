<%@page import="in.jugchennai.urbantravellers.game.GameCache"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="gameboard.js"></script>
    </head>
    <body>
        <h1>UrbanTravellers</h1>
        <%
            String nexplayr = GameCache.getInstance().getBoard().getFirstPlayer();
        %>
        <input type="text" value="<%= request.getParameter("player")%>">
        <%
            if (nexplayr.equals(request.getParameter("player").toString())) {
        %>
        <button type="button" onclick="rolldice(<%request.getParameter("player").toString();%>)">RollDice</button>
        <%            }
        %>
    </body>
</html>
