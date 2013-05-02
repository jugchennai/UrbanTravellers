
var wsUri = "ws://localhost:8080/urbantravellers/GameBoardWS";
var websocket = new WebSocket(wsUri);
websocket.binaryType = "arraybuffer";
var output = document.getElementById("output");
websocket.onmessage = function(evt) {
    onMessage(evt);
};
websocket.onerror = function(evt) {
    onError(evt);
};

function rolldice(json) {
    var diceThrow = new Object();
    diceThrow.playerName = json;
    diceThrow.diceValue = "" + Math.floor((Math.random() * 6) + 1) + "";
    var jsonst = JSON.stringify(diceThrow);
    console.log("sending text: " + jsonst);
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
                resp.diceValue + " and moved to " + resp.newPosition + "</p>" +
                "<p> next player to  move " + resp.nextplayer + "</p>";
    } else {
        document.getElementById("output").innerHTML = "<h1> Congrats  " + resp.nextplayer + " won the game </h1>";
    }
}

function onError(evt) {
    console.log("error in handling msg");
}

function writeToScreen(message) {

}
