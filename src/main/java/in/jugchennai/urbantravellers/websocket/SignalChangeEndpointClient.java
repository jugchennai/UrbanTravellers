/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.jugchennai.urbantravellers.websocket;

import in.jugchennai.urbantravellers.game.GameBoard;
import in.jugchennai.urbantravellers.game.GameBoardConfig;
import in.jugchennai.urbantravellers.game.GameCache;
import in.jugchennai.urbantravellers.game.SignalPoint;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.ClientEndpoint;
import javax.websocket.EncodeException;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint(decoders = {DataDecoder.class}, encoders = {DataEncoder.class})
public class SignalChangeEndpointClient {

    private static final GameCache cache = GameCache.getInstance();

    @OnOpen
    public void onOpen(Session session) throws IOException, EncodeException {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        GameBoard gameBoard = cache.getBoard();
        GameBoardConfig boardConfig = gameBoard.getBoardConfig();
        for (SignalPoint signalPoint : boardConfig.getSigPos()) {
            builder.add(String.valueOf(signalPoint.getSignalPos()), signalPoint.getSignalColor().name());
        }
        session.getBasicRemote().sendObject(builder.build());
    }
}
