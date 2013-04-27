
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
        pre.innerHTML = "all players joined <br> <a href='game.jsp?player=" + plyrName + "' class='btn btn-primary btn-small' >Lets Start </a> ";
    } else {
        var plnames = resp.player.split(",");
        var x = "<ul>";
        for (var i = 0; i < plnames.length - 1; i++) {
            x = x + "<li>" + plnames[i] + "</li>";
        }
        x = x + "</ul>";
        pre.innerHTML = x;
    }
    document.getElementById("output").innerHTML = pre.innerHTML;
}
