<%@page import="in.jugchennai.urbantravellers.game.Player"%>
<%@page import="in.jugchennai.urbantravellers.game.GameBoard"%>
<%@page import="in.jugchennai.urbantravellers.game.GameCache"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%GameBoard board = GameCache.getInstance().getBoard();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/gameboard.js"></script>
        <script src="js/kinetic-v4.3.3.min.js"></script>
        <script src="js/KineticCar.js"></script>
        <link href="css/bootstrap.css" rel="stylesheet">
        <style type="text/css">
            body {
                margin-top: 15px;
            }
        </style>
        <script type="text/javascript">
            function init() {
            <%
                for (Player player : board.getPlayerObsOnBoard()) {
            %>
                UB.addCar(<%=player.getSerialNo()%>);
            <%
                }
            %>
            }
            window.addEventListener("load", init, false);
        </script>  
        <link href="css/bootstrap-responsive.css" rel="stylesheet">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span10 offset1">
                    <div class="span8">
                        <div id="container"></div>
                    </div>
                    <div class="span2">
                        <h1>UrbanTravellers</h1>
                        <input type="text" id="playerName" value="<%= request.getParameter("player")%>">
                        <%
                            if (board.getFirstPlayer().equals(request.getParameter("player").toString())) {
                        %>
                        <button class="btn btn-primary" type="button" id="firstRoll" onclick="rolldice('<%= request.getParameter("player")%>')">RollDice</button>
                        <button class="btn btn-primary" type="button" id="dicer" style="display: none" onclick="rolldice('<%= request.getParameter("player")%>')">RollDice</button>
                        <%
                        } else {
                        %>
                        <button class="btn btn-primary" type="button" id="dicer" style="display: none" onclick="rolldice('<%= request.getParameter("player")%>')">RollDice</button>
                        <% }%>
                        <div id="output">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
