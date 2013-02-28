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
  	var dice,name;
	var wsUri = "ws://localhost:8080/UrbanTravellers-Web/UTGameDashSocket";
	var websocket = new WebSocket(wsUri);
        websocket.onopen = function(evt) { onOpen(evt) };
        websocket.onmessage = function(evt) { onMessage(evt) };
        websocket.onerror = function(evt) { onError(evt) };  
            
	function init() {
            output = document.getElementById("output");    
        }
			
        function say_hello() {

            name = document.getElementById("createGame:nameField").value;                                
            var json = JSON.stringify({
                "type" : "createGame",    //type of request for processing createGame will trigger createGame code and roll_dice will trigger roll_dice code
                "gameId" :name,
                "playerName": "mgosemath"
            });

            websocket.send(json);
            writeToScreen("SENT: " +json);
            console.log("Msg Sent"+json);   
            turnmodule();       	
        }

            function roll()
            {

            }

        function onOpen(evt) {
            alert("Connected");
            writeToScreen("WELCOME !!!! you have been now placed in the game board !!! ");
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
            if(json.type==="createGame")   //list the newly created games as sidebar
            {
                var temp=document.createElement("newDiv");
                temp.innerHTML="<div class='box'><form>"+
                                "Name :"+json.gameId+"<br/>"+
                                "Players :"+json.players+"<br/>"+
                                "<input class='btn btn-primary' type='button' value='Join' /></form></div>";
                document.getElementById("games").appendChild(temp);
            }
            //obj = JSON.parse(json);
            //var some=JSON.parse(evt.data);
            //alert(some.gameId);
            console.log("Msg Recieving");
            console.log(ab);
            writeToScreen("RECEIVED: " + evt.data);
            //updateScore(obj);
        }

        function writeToScreen(message) {
            var pre = document.createElement("p");
            pre.style.wordWrap = "break-word";
            pre.innerHTML = message;
            output.appendChild(pre);
        }

	//to hide the game create form and display roll dice form
        function turnmodule()
        {	
            document.getElementById("createGame").style.display="none";
            document.getElementById("rollDice").style.display="block";
        }
