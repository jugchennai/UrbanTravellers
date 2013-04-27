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
        <input type="text" id="playerName" value="<%= request.getParameter("player")%>">
        <%
            if (GameCache.getInstance().getBoard().getFirstPlayer().equals(request.getParameter("player").toString())) {
        %>
        <button type="button" id="firstRoll" onclick="rolldice('<%= request.getParameter("player")%>')">RollDice</button>
        <%
        } else {
        %>
        <button type="button" id="dicer" style="display: none" onclick="rolldice('<%= request.getParameter("player")%>')">RollDice</button>
        <% }%>
    </body>
</html>
