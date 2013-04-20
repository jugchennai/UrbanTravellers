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
	
	var dice,name, username, websocket;
	var players = new Array();
	var positions = new Array();
	
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
			var position = document.getElementById("rollDice:positionField").value;
            document.getElementById("rollDice:positionField").value = parseInt(position) + dice;
			position = parseInt(position)+dice;
			UB.moveCar(getIndex(name)+1, position);
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
			if(newurl==="game.xhtml")
			{
				getPlayers();
			}
        }

        function onError(evt) {
            writeToScreen('<span style="color: red;">ERROR:</span> ' + evt);
        }

        function onMessage(evt) {
            var ab =evt.data;
            var json = JSON.parse(ab);
			if(json.type==="loadGames")
			{
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
				var output="";
				//name=document.getElementById("rollDice:userName").value;
				if(name!=json.playerName)
				{
					temp=document.createElement("newDiv");
					temp.innerHTML="<p>"+json.playerName+" joined.</p>";
					document.getElementById("games").appendChild(temp);
				}
				var numbers = json.players.length;
				for(var i=0;i<numbers;i++)
				{
					output += json.players[i]+" joined the game<br/>";
				}
				document.getElementById("players").innerHTML=output;
					
				if(numbers>=3)
				{
					setTimeout(function() { alert("Loading Gameboard"); window.location.href="game.xhtml"; }, 3000);
				}
						
			}
			
			if(json.type==="roll")
			{
			
				name=document.getElementById("rollDice:userName").value;
					//temp=document.createElement("newDiv");
					//temp.innerHTML="<p>"+json.player+"("+json.position+") rolled "+json.diceValue+"</p>";
					//document.getElementById("games").appendChild(temp);
				var index = getIndex(json.player)+1;
				if(json.position<=99)
				{
					UB.moveCar(index, json.position);
					if(index>=players.length)
					{
						index=0;
					}
					document.getElementById(json.player).innerHTML=json.position;
					var output="<p>"+json.player+" rolled "+json.diceValue+"</p>";
					output+="<p>"+players[index]+"&apos;s turn</p>";
					document.getElementById("games").innerHTML=output;
					if(json.position===99)
					{
						alert(json.player+" won!!!");
					}
				}
			}
			
			if(json.type==="getPlayers")
			{
				var output="";
				var length = json.players.length;
				for(var i=0;i<length;i++)
				{
					players[i] = json.players[i];
					positions[i] = 0;
					UB.addCar(i+1);	
					output+="<div id='car_img'><img src='../resources/img/car"+(i+1)+".png' /></div>";
					output+="<div id='playername'>"+json.players[i]+"</div>";
					output+="<div class='score' id="+json.players[i]+">0</div>"
					output+="<br/><br/>";
				}
				document.getElementById("players").innerHTML=output;
				document.getElementById("games").innerHTML="<p>"+players[0]+"&apos;s turn</p>";
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
           	"type" : "loadGames",
			"gameId" : "game1"
        });

       	websocket.send(json);
       	writeToScreen("SENT: " +json);
       	console.log("Msg Sent"+json);	
	}
		
	function join()
	{
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
	
	function getPlayers()
	{
		name = document.getElementById("rollDice:userName").value;
		var json = JSON.stringify({
            "type" : "getPlayers",
            "gameId" : "game1",
            "playerName": name,
            "diceValue": 0
        });
                
        websocket.send(json);
        writeToScreen("SENT: " +json);
	}
	
	function getIndex(name)
	{
		for(var i=0;i<3;i++)
		{
			if(name===players[i])
			{
				return i;
			}
		}
		return 0;
	}