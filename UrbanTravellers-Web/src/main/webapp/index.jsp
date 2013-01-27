<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Urban Travelers</title>
        <script language="javascript" type="text/javascript">
            var dice,name;
            var wsUri = "ws://127.0.0.1:8080/urbantravellers/gameBoard";
            var websocket = new WebSocket(wsUri);
            websocket.onopen = function(evt) { onOpen(evt) };
            websocket.onmessage = function(evt) { onMessage(evt) };
            websocket.onerror = function(evt) { onError(evt) };
            
            function init() {
                output = document.getElementById("output");
            }

            function say_hello() {
                name = document.getElementById("nameField").value; 
                dice = Math.floor((Math.random()*6)+1);
                document.getElementById("diceField").value = dice;
                pos = document.getElementById("positionField").value;
                
                var json = JSON.stringify({
                    "gameId" :"game1",
                    "playerName": name,
                    "diceValue": dice
                });
                
                websocket.send(json);
               //  writeToScreen("SENT: " +json);
                console.log("Msg Sent"+json);   
                document.getElementById("positionField").value = parseInt(dice) 
                    + parseInt(pos);
                document.getElementById("diceField").value=dice;  
            }

            function onOpen(evt) {
                writeToScreen("CONNECTED");
            }

            function onMessage(evt) {
                var ab =evt.data;
                console.log("Msg Recieving");
                console.log(evt);
                writeToScreen("RECEIVED: " + evt.data);
                
            }

            function onError(evt) {
                writeToScreen('<span style="color: red;">ERROR:</span> ' + evt);
            }

            function writeToScreen(message) {
                var pre = document.createElement("p");
                pre.style.wordWrap = "break-word";
                pre.innerHTML = message;
                output.appendChild(pre);
            }

            window.addEventListener("load", init, false);
        </script>
    </head>
    <body>
        <h1>Urban Travellers</h1>
        <br/>
        <table>
            <tr>
                <td>
                    <div style="text-align: center;">
                        <form action=""> 
                            <label>Name:</label>
                            <input id="nameField" placeholder="Name"type="text"/><br><br>
                            <label>Dice Count:</label>
                            <input id="diceField" disabled="disabled" placeholder="Dice"type="text"/><br><br>
                            <label>Position</label>
                            <input id="positionField" placeholder="Position"type="text" value="0"><br><br>
                            <input onclick="say_hello()" value="Roll" type="button"/>
                        </form>
                    </div>
                </td>
                <td>
                    <div id="output"></div>
                </td>    
            </tr>
        </table>    
    </body>
</html>