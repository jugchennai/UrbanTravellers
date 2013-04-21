/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.jugchennai.urbantravellers.websocket;

import in.jugchennai.urbantravellers.game.GameBoard;
import in.jugchennai.urbantravellers.game.GameCache;
import in.jugchennai.urbantravellers.game.Player;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.OnMessage;
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

    protected Set<Session> peers = Collections.synchronizedSet(new HashSet());

    public void onOpen(Session peer) throws Exception {
        peers.add(peer);
    }

    public void onClose(Session peer) {
        peers.remove(peer);
    }
    private GameCache cache = GameCache.getInstance();

    @OnMessage
    public void moveplayer(GameData gd, Session session) {
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
            for (Session currPeer : peers) {
                currPeer.getBasicRemote().sendObject(gamedata);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
