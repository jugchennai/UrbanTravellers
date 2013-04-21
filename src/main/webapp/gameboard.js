
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
    diceThrow.diceValue = Math.floor((Math.random() * 6) + 1);
    var jsonst = JSON.stringify(diceThrow);
    console.log("sending text: " + jsonst);
    //websocket.send(jsonst);
}

function onMessage(evt) {
    console.log("received: " + evt.data);
}

function onError(evt) {
    console.log("error in handling msg")
}

function writeToScreen(message) {
    var pre = document.createElement("p");
    pre.style.wordWrap = "break-word";
    var resp = eval("(" + message.toString() + ")");
    if (resp.startGame) {
        var plyrName = document.getElementById("plyrName").value;
        pre.innerHTML = "all player joined <a href='game.jsp?player=" + plyrName + "' class='btn btn-primary btn-small' >Lets Start </a> ";
    } else {
        var plnames = resp.player.split(",");
        var x = "<ul>"
        for (var i = 0; i < plnames.length - 1; i++) {
            x = x + "<li>" + plnames[i] + "</li>"
        }
        x = x + "</ul>"
        pre.innerHTML = x;
    }
    document.getElementById("output").innerHTML = pre.innerHTML;
}
