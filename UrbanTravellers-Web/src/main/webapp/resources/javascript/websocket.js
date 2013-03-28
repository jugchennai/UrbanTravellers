/* 
 * Copyright 2012 JUGChennai.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
   		var dice,name, username, websocket;
	
	var bootsocket = "ws://localhost:8080/UrbanTravellers-Web/UTGameBootSocket";
	
	function createsocket(socket){
	
		var wsUri = "ws://localhost:8080/UrbanTravellers-Web/"+socket;
		websocket = new WebSocket(wsUri);
		websocket.onopen = function(evt) { onOpen(evt) };
		websocket.onmessage = function(evt) { onMessage(evt) };
		websocket.onerror = function(evt) { onError(evt) };  
	}
	
	function init() {
            output = document.getElementById("output");    
        }

        function rollDice()
        {
            name = document.getElementById("rollDice:userName").value;
            dice = Math.floor((Math.random()*6)+1);
            document.getElementById("rollDice:rollvalue").value=dice;
                
            var json = JSON.stringify({
                    "type" : "roll",
                    "gameId" : "game1",
                    "playerName": name,
                    "diceValue": dice
                });
                
                websocket.send(json);
                writeToScreen("SENT: " +json);
        }

        function onOpen(evt) {
            alert("Connected");
            writeToScreen("WELCOME !!!! you have been now placed in the game board !!! ");
			var url=window.location.pathname;
			var newurl=url.substring(url.lastIndexOf('/') + 1)
			if(newurl==="createGame.xhtml")
			{
				var name=document.getElementById("createGame:userName").value;
				onConnected(name);
			}
			if(newurl==="gamedash.xhtml")
			{
				addPlayer();
			}
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

        function onMessage(evt) {
            //alert("Response received");
            var ab =evt.data;
            var json = JSON.parse(ab);
            
            if(json.type==="addPlayer")
            {
				var content="";
				var players = json.players;
				for(var i=0;i<players.length;i++)
				{
					content += players[i]+" joined the game.<br/>";
				}
				writeToScreen(content);
                content="<div class='box'>"+
                                "Name :"+json.gameId+"<br/>"+
                                "Players :"+json.players+"<br/></div>";
				document.getElementById("activeGames").innerHTML=content;
				if(json.startGame==false)
				{
					//writeToScreen("Waiting for others to join.");
				}
				else
				{
					writeToScreen("Loading Game.");
				}
            }
            console.log("Msg Recieving");
            console.log(ab);
            //writeToScreen("RECEIVED: " + evt.data);
        }

        function writeToScreen(message) {
            var pre = document.createElement("p");
            pre.style.wordWrap = "break-word";
			output.innerHTML=message;
            /*pre.innerHTML = message;
            output.appendChild(pre);*/
        }
		
		function onConnected(name)
		{
            var json = JSON.stringify({
                "type" : "addPlayer",
				"gameId" : "game1",
				"player" : name
            });

            websocket.send(json);
            //writeToScreen("SENT: " +json);
            console.log("Msg Sent"+json);
		}
				
		function notify()
		{
            temp=document.createElement("newDiv");
            temp.innerHTML="<p>You joined the game.</p>";
            document.getElementById("games").appendChild(temp);
            var json = JSON.stringify({
                       "type" : "notify",
                       "gameId" : "game1",
                       "playerName": "mgosemath"
            });

            websocket.send(json);
            writeToScreen("SENT: " +json); 
        }
		
