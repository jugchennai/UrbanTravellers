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
var players = new Array();
var positions = new Array();	
	
	function initsocket(socket){
		var wsUri = "ws://localhost:8080/UrbanTravellers-Web/"+socket;
		websocket = new WebSocket(wsUri);
		websocket.onopen = function(evt) { onOpen(evt) };
		websocket.onmessage = function(evt) { onMessage(evt) };
		websocket.onerror = function(evt) { onError(evt) };  
	}

	function rollDice()
        {
            name = document.getElementById("rollDice:userName").value;
            dice = Math.floor((Math.random()*6)+1);
            document.getElementById("rollDice:diceField").value=dice;
			var position = document.getElementById("rollDice:positionField").value;
			UB.moveCar(getIndex(name)+1, position);
            document.getElementById("rollDice:positionField").value = position + dice;
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
		getPlayers();
	}
	
	function onError(evt) {
        writeToScreen('<span style="color: red;">ERROR:</span> ' + evt);
    }
	
	function onMessage(evt) {
        alert("Response received");
        var ab =evt.data;
        var json = JSON.parse(ab);
		if(json.type==="roll")
		{
				//var numbers = json.players.length;
				//if(name!=json.playerName)
				//{
			temp=document.createElement("newDiv");
			temp.innerHTML="<p>"+json.player+" rolled "+json.diceValue+"</p>";
			document.getElementById("games").appendChild(temp);
				//}
				/*for(var i=0;i<numbers;i++)
				{
					output += json.players[i]+" joined the game<br/>";
				}*/
		}
		
		if(json.type==="getPlayers")
		{
			var temp = document.createElement("newDiv");
			temp.innerHTML="";
			var length = json.players.length;
			for(var i=0;i<length;i++)
			{
				players[i] = json.players[i];
				position[i] = 0;
				UB.addCar(i+1);
				temp.innerHTML+="<p>"+json.player+" "+UB.getCarLocation(i+1)+"</p><br/>";
			}
			document.getElementById("games").innerHTML=temp;
		}
			
		console.log("Msg Recieving");
		console.log(ab);
		writeToScreen("RECEIVED: " + evt.data);
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