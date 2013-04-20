<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Urban Travelers</title>
        <script language="javascript" type="text/javascript">
            var dice,name;
            var wsUri = "ws://" + document.location.host + "/UrbanTravellers-Web/UTGameDashSocket";
            var websocket = new WebSocket(wsUri);
            websocket.onopen = function(evt) { onOpen(evt) };
            websocket.onmessage = function(evt) { onMessage(evt) };
            websocket.onerror = function(evt) { onError(evt) };  
            function init() {
                output = document.getElementById("output");    
          }

            function say_hello() {
                name = document.getElementById("nameField").value; 
                                
                var json = JSON.stringify({
                    "gameId" :name,
                    "playerName": "mgosemath"
                });
                
                websocket.send(json);
                writeToScreen("SENT: " +json);
                console.log("Msg Sent"+json);   
                
            }

            function onOpen(evt) {
                writeToScreen("WELCOME !!!! you have been now placed in the game board !!! ");
            }

            function onMessage(evt) {
                writeToScreen("Message Received");
                var ab =evt.data;
                var json = ab
                obj = JSON.parse(json)
                console.log("Msg Recieving");
                console.log(ab);
                writeToScreen("RECEIVED: " + evt.data);
                //updateScore(obj)
            }

            function onError(evt) {
                writeToScreen('<span style="color: red;">ERROR:</span> ' + evt);
            }
            
            function updateScore(obj) {
                if(obj.player === "Pras") {
                    prasscore.innerHTML = obj.position
                } else if (obj.player === "Raj") {
                    rajscore.innerHTML = obj.position
                }
            }

            function writeToScreen(message) {
                var pre = document.createElement("p");
                pre.style.wordWrap = "break-word";
                pre.innerHTML = message;
                output.appendChild(pre);
            }

            window.addEventListener("load", init, false);
        </script>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css">
        <script type="text/javascript" src="resources/javascript/websocket.js"></script>
   
    </head>
    <body>
        <div class="container-fluid">
            <div class="row-fluid">
                <h1>Urban Travelers</h1>
                <hr>
            </div>
            <div class="row-fluid">
                <div class="span3">
                    <form action=""> 
                        <label>Dice Count:</label>
                        <input id="diceField" disabled="disabled" placeholder="Dice"type="text"/><br><br>
                        <!-- <label>Position</label> -->
                        <input id="positionField" placeholder="Position" type="hidden" value="0"><br><br>
                        <input class="btn btn-primary btn-large" onclick="say_hello()" value="Roll" type="button" />
                        <input class="btn-primary btn-large"  value="Toggle Signal" type="button"/>
                        <input type="hidden" id="userName" value=<%=loginBean.userName %> />
                    </form>
                </div>
                <div class="span9">
                    <div id="output"></div>
                    <div class="span6" id="score">
                        <h2>Position</h2>
                        <div class="span3">
                            <h4>
                                Pras
                            </h4> 
                            <div id="prasScore">
                                
                            </div>
                        </div>
                        <div class="span3">
                            <h4>
                                Raj 
                            </h4> 
                            <div id="rajScore">
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
