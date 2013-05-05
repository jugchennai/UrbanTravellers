
var wsUri = "ws://localhost:8080/urbantravellers/GameBoardWS";
var websocket = new WebSocket(wsUri);
var bs = [];
websocket.binaryType = "arraybuffer";
var output = document.getElementById("output");
websocket.onmessage = function(evt) {
    onMessage(evt);
};
websocket.onerror = function(evt) {
    onError(evt);
};

function rolldice(json, isBs) {
    var diceThrow = new Object();
    diceThrow.playerName = json;
    var dv = Math.floor((Math.random() * 6) + 1);
    if (isBs) {
        document.getElementById("output").innerHTML = "<p> your are in booster zone </p>";
        dv = dv + Math.floor((Math.random() * 6) + 1);
    }
    diceThrow.diceValue = "" + dv + "";
    var jsonst = JSON.stringify(diceThrow);
    console.log("sending text: " + jsonst);
    console.log("isBS " + isBs);
    websocket.send(jsonst);
    if (document.getElementById("firstRoll")) {
        document.getElementById("firstRoll").style.display = "none";
    }
    document.getElementById("dicer").style.display = "none";
}

function onMessage(evt) {
    console.log("received: " + evt.data);
    var resp = eval("(" + evt.data + ")");
    var plyr = document.getElementById("playerName").value;
    if (resp.nextplayer) {
        if (plyr === resp.nextplayer) {
            document.getElementById("dicer").style.display = "block";
        } else {
            document.getElementById("dicer").style.display = "none";
        }
    }
    UB.moveCar(resp.plrNo, resp.newPosition);
    var gameStop = resp.gameEnd;
    if (!gameStop) {
        document.getElementById("output").innerHTML = "<p>" + resp.player + " rolled " +
                resp.diceValue + "</p>" +
                "<p> next player to  move " + resp.nextplayer + "</p>";
        writeToScreen(resp.standings);
    } else {
        document.getElementById("output").innerHTML = "<h1> GameOver !!!!  "
                + resp.player + " won the game </h1> <a href='rest.jsp' class='btn btn-primary'>Start Over</a>";
    }
}

function onError(evt) {
    console.log("error in handling msg");
}

function addBs(bspos) {
    bs.push(bspos);
}

function writeToScreen(message) {
    var standings = "";
    for (i in message) {
        standings += "<p><b>" + message[i].name + "</b>  :  " + message[i].position + "</p>";
    }
    document.getElementById("standings").innerHTML = standings;
}

var scUri = "ws://localhost:8080/urbantravellers/SignalChange";
var scSocket = new WebSocket(scUri);

scSocket.onmessage = function(evt) {
    console.log("signal change call back " + evt.data);
    var sigch = eval("(" + evt.data + ")");
    UB.addSignal(sigch.point, sigch.color);
};

scSocket.onerror = function(evt) {
    console.log(evt.data);
};
