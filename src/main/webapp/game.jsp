<%@page import="in.jugchennai.urbantravellers.game.GameBoard"%>
<%@page import="in.jugchennai.urbantravellers.game.GameCache"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/gameboard.js"></script>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.css" rel="stylesheet">
    </head>
    <body>
        <div class="container-fluid">
            <h1>UrbanTravellers</h1>
            <div class="row-fluid">

                <div class="span10">
                    <div id="container"></div>
                    <script src="js/kinetic-v4.3.3.min.js"></script>
                    <script src="js/KineticCar.js"></script>
                </div>
                <div class="span2">
                    <input type="text" id="playerName" value="<%= request.getParameter("player")%>">
                    <%
                        GameBoard board = GameCache.getInstance().getBoard();
                        if (board.getFirstPlayer().equals(request.getParameter("player").toString())) {
                    %>
                    <button class="btn btn-primary" type="button" id="firstRoll" onclick="rolldice('<%= request.getParameter("player")%>')">RollDice</button>
                    <button class="btn btn-primary" type="button" id="dicer" style="display: none" onclick="rolldice('<%= request.getParameter("player")%>')">RollDice</button>
                    <%
                    } else {
                    %>
                    <button class="btn btn-primary" type="button" id="dicer" style="display: none" onclick="rolldice('<%= request.getParameter("player")%>')">RollDice</button>
                    <% }%>
                </div>
            </div>
        </div>
    </body>
</html>
