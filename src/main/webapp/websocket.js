
var wsUri = "ws://localhost:8080/urbantravellers/HomeWS";
var websocket = new WebSocket(wsUri);
websocket.binaryType = "arraybuffer";
var output = document.getElementById("output");
websocket.onmessage = function(evt) {
    onMessage(evt);
};
websocket.onerror = function(evt) {
    onError(evt);
};

function sendText(json) {
    var jsonst = JSON.stringify({
        "playerName": json
    });
    console.log("sending text: " + jsonst);
    websocket.send(jsonst);
}

function onMessage(evt) {
    console.log("received: " + evt.data);
    writeToScreen(evt.data);
}

function onError(evt) {
    writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}

function writeToScreen(message) {
    var pre = document.createElement("p");
    pre.style.wordWrap = "break-word";
    var resp = eval("(" + message.toString() + ")");
    if (resp.startGame) {
        var plyrName = document.getElementById("plyrName").value;
        pre.innerHTML = "all player joined <a href='game.jsp?player=" + plyrName + "'>Lets Start </a> ";
    } else {
        pre.innerHTML = resp.player;
    }
    document.getElementById("output").innerHTML = pre.innerHTML;
}
