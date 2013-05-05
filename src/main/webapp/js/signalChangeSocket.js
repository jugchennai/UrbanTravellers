
var wsUri = "ws://localhost:8080/urbantravellers/SignalChange";
var websocket = new WebSocket(wsUri);
websocket.binaryType = "arraybuffer";

websocket.onmessage = function(evt) {
    onMessage(evt);
};

websocket.onerror = function(evt) {
    onError(evt);
};

function onMessage(evt) {
    console.log("received: " + evt.data);
}

function onError(evt) {
}

function writeToScreen(message) {

}
