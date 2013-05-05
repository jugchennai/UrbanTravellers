<%@page import="in.jugchennai.urbantravellers.game.SignalPoint"%>
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
        <link href='http://fonts.googleapis.com/css?family=Sansita+One' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Chewy' rel='stylesheet' type='text/css'>
        <link href="css/bootstrap.css" rel="stylesheet">
        <style type="text/css">
            body {
                font-family: 'Chewy', cursive;
                font-weight: bold;
                font-size: 25px;
                line-height: 35px;
                color: #149bdf;
            }    

            .game-hero {
                padding: 2px;
                font-weight: 200;
                line-height: 10px;
                color: inherit;
                background-color: #a9302a;
                -webkit-border-radius: 2px;
                -moz-border-radius: 2px;
                border-radius: 2px;
            }

            .sub-title {
                font-family: 'Sansita One', cursive; 
                font-size: 20px;
                font-weight: bold;
                line-height: 20px;
                letter-spacing: -1px;
                text-align: center;
                color: #fff;
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
                for (SignalPoint point : board.getBoardConfig().getSigPos()) {
            %>
                UB.addSignal(<%= point.getSignalPos()%>, "RED");
            <%
                }
                for (Integer bs : board.getBoardConfig().getBs()) {
            %>
                UB.addBooster(<%= bs%>);
                addBs(<%= bs%>)
            <%                }
            %>
            }
            window.addEventListener("load", init, false);
        </script>  
        <link href="css/bootstrap-responsive.css" rel="stylesheet">
    </head>
    <body>
        <div class="game-hero">
        </div>
        <div class="container-fluid">
            <div class="row-fluid">

                <div class="span2" style="background-color: #a9302a;">
                    <img src="images/urbanTravellers.png">
                    <p class="sub-title">Urban Travellers</p>
                    <img src="images/images.jpeg">
                </div>

                <div class="span7">
                    <div id="container"></div>
                </div>

                <div class="span3" style="background-color: #a9302a;color: #fff; text-align: center">
                    <input type="hidden" id="playerName" value="<%= request.getParameter("player")%>">
                    <input type="hidden" id="plId" value="<%=board.getPlayerPosition(request.getParameter("player"))%>">
                    <%= request.getParameter("player")%>   
                </div>
                <hr>
                <div class="span3">
                    <%
                        boolean isBs = board.isPlayerInBs(request.getParameter("player"));
                        if (board.getFirstPlayer().equals(request.getParameter("player").toString())) {
                    %>
                    <button class="btn btn-primary" type="button" id="dicer" style="display: block"  
                            onclick="rolldice('<%= request.getParameter("player")%>',<%=isBs%>)">RollDice</button>
                    <%
                    } else {
                    %>
                    <button class="btn btn-primary" type="button" id="dicer" style="display: none" 
                            onclick="rolldice('<%= request.getParameter("player")%>',<%=isBs%>)">RollDice</button>
                    <%
                            
                        }%>
                    <div id="output">
                    </div>
                    <div id="standings">
                    </div>
                </div>

            </div>
        </div>
        <div class="game-hero">
            <p class="sub-title">
                JUGChennai - Adopt A JSR 
            </p>
        </div>             
    </body>
</html>
