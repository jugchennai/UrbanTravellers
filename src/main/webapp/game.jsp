<%@page import="in.jugchennai.urbantravellers.game.GameCache"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            alert("game has started");
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            String nexplayr = GameCache.getInstance().getBoard().getNextPlayer(request.getParameter("player"));
        %>
        <input type="text" value="<%= request.getParameter("player")%>">
        <%
            if (nexplayr.equals(request.getParameter("player").toString())) {
        %>
        <button type="button">Play</button>
        <%            }
        %>
    </body>
</html>
