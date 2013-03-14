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
			
        function say_hello() {

            name = document.getElementById("createGame:nameField").value;           
			username=document.getElementById("createGame:userName").value;
            var json = JSON.stringify({
                "type" : "createGame",
				"status" : "pageLoaded",
                "gameId" :name,
                "playerName": username
            });

            websocket.send(json);
            writeToScreen("SENT: " +json);
            console.log("Msg Sent"+json);   
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
            //alert("Connected");
            writeToScreen("WELCOME !!!! you have been now placed in the game board !!! ");
	    var url=window.location.pathname;
	    var newurl=url.substring(url.lastIndexOf('/') + 1)
	    if(newurl==="createGame.xhtml")
	    {
		onConnected();
	    }
	    if(newurl==="gameboard.xhtml")
	    {
		notify();
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
            alert("Response received");
            var ab =evt.data;
            var json = JSON.parse(ab);
	    if(json.type==="loadGames")
	    {
		alert("Loading Game List");
		if(json.status==="no_game")
		{
			var temp=document.createElement("newDiv");
			temp.innerHTML="<div id='no_game' class='noGame'>"+
                        "<p>No Active Game</p>"+
                        "</div>";
			document.getElementById("games").appendChild(temp);
		}
	    }
            if(json.type==="createGame"||json.status==="active")
            {
		alert("Game Found.");
		if(document.getElementById("no_game"))
		{
			document.getElementById("no_game").style.display="none";
                }
		temp=document.createElement("newDiv");
                temp.innerHTML="<div class='box'><form>"+
                                "Name :"+json.gameId+"<br/>"+
                                "Players :"+json.players+"<br/>"+
				"<input type='hidden' value='"+json.gameId+"' id='hid'><br/>"+
                                "<input id='joinGame' class='btn btn-primary' type='button' onclick='join()' value='Join' /></form></div>";
                document.getElementById("games").appendChild(temp);
            }
	    if(json.type==="notify")
	    {
		alert("Player joined the game.");
		name=document.getElementById("rollDice:userName").value;
		if(name!=json.playerName)
		{
			temp=document.createElement("newDiv");
			temp.innerHTML="<p>"+json.playerName+" joined.</p>";
			document.getElementById("games").appendChild(temp);
		}
		var numbers=json.number;
			
		if(numbers>=3)
		{
			document.getElementById("rollDice:roll").disabled=false;
		}
				
	    }
            console.log("Msg Recieving");
            console.log(ab);
            writeToScreen("RECEIVED: " + evt.data);
        }

        function writeToScreen(message) {
            var pre = document.createElement("p");
            pre.style.wordWrap = "break-word";
            pre.innerHTML = message;
            output.appendChild(pre);
        }
		
	function onConnected()
	{
		var json = JSON.stringify({
                	"type" : "loadGames"
        	});

            	websocket.send(json);
            	writeToScreen("SENT: " +json);
            	console.log("Msg Sent"+json);
	}
		
	function join()
	{
		name = document.getElementById("hid").value;     
		username=document.getElementById("createGame:userName").value;
        	var json = JSON.stringify({
                	"type" : "gameJoined",
                	"gameId" :name,
                	"playerName": username
            	});

            	websocket.send(json);
            	writeToScreen("SENT: " +json);
            	window.location.href="gameboard.xhtml";
		
	}
		
	function notify()
	{
		temp=document.createElement("newDiv");
		temp.innerHTML="<p>You joined the game.</p>";
		document.getElementById("games").appendChild(temp);
		name=document.getElementById("rollDice:userName").value;
		var json = JSON.stringify({
        	        "type" : "notify",
                        "gameId" : "game1",
                        "playerName": name
                });

                websocket.send(json);
                writeToScreen("SENT: " +json); 
	}
