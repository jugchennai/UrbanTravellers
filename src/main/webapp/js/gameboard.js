
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
    if ((resp.nextplayer) && (plyr == resp.nextplayer)) {
        document.getElementById("dicer").style.display = "block";
    } else {
        document.getElementById("dicer").style.display = "none";
    }
}

function onError(evt) {
    console.log("error in handling msg")
}

function writeToScreen(message) {
    
}
