/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.jugchennai.urbantravellers.websocket;

import in.jugchennai.urbantravellers.game.GameBoard;
import in.jugchennai.urbantravellers.game.GameCache;
import in.jugchennai.urbantravellers.game.Player;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author prasannakumar
 */
@ServerEndpoint(value = "/GameBoardWS",
        encoders = {DataEncoder.class},
        decoders = {DataDecoder.class})
public class GameBoardSocket {

    protected static Set<Session> peers = Collections.synchronizedSet(new HashSet());
    private GameCache cache = GameCache.getInstance();

    @OnOpen
    public void onOpen(Session peer) throws Exception {
        System.out.println("connecting to peer");
        System.out.println("size of peers " + peers.size());
        peers.add(peer);
    }

    @OnClose
    public void onClose(Session peer) {
        System.out.println("disconnecting from peer");
        peers.remove(peer);
    }

    @OnMessage
    public void boradcastMovePlayer(GameData gd, Session session) throws IOException,
            EncodeException {
        try {
            String playerName = gd.getJson().getString("playerName");
            String diceValue = gd.getJson().getString("diceValue");
            GameBoard board = cache.getBoard();
            Player player = board.movePlayerPosition(playerName,
                    Integer.parseInt(diceValue));
            GameData gamedata = new GameData();
            JsonObjectBuilder json = Json.createObjectBuilder();
            json.add("player", player.getName());
            json.add("position", player.getPosition());
            json.add("diceValue", player.getDiceValue());
            json.add("nextplayer", board.getNextPlayer(playerName));
            gamedata.setJson(json.build());
            gd = gamedata;
            for (Session currPeer : peers) {
                currPeer.getBasicRemote().sendObject(gd);
            }
        } catch (NumberFormatException | IOException | EncodeException ex) {
            ex.printStackTrace();
        }
    }
}
