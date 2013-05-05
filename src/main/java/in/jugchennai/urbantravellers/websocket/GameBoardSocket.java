package in.jugchennai.urbantravellers.websocket;

import in.jugchennai.urbantravellers.game.GameBoard;
import in.jugchennai.urbantravellers.game.GameCache;
import in.jugchennai.urbantravellers.game.Player;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.apache.log4j.Logger;

/**
 *
 * @author prasannakumar
 */
@ServerEndpoint(value = "/GameBoardWS",
        encoders = {DataEncoder.class},
        decoders = {DataDecoder.class})
public class GameBoardSocket {

    private Logger logger = Logger.getLogger(GameBoardSocket.class);
    protected static Set<Session> peers = Collections.synchronizedSet(new HashSet());
    private GameCache cache = GameCache.getInstance();

    @OnOpen
    public void onOpen(Session peer) throws Exception {
        peers.add(peer);
    }

    @OnClose
    public void onClose(Session peer) {
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
            String next = board.getNextPlayer(playerName);
            GameData gamedata = new GameData();
            JsonObjectBuilder json = Json.createObjectBuilder();
            json.add("player", player.getName());
            json.add("oldPosition", player.getOldPosition());
            json.add("newPosition", player.getPosition());
            json.add("diceValue", player.getDiceValue());
            json.add("nextplayer", next);
            json.add("plrNo", player.getSerialNo());
            json.add("nextPlrNo", board.getPlayerPosition(next));
            json.add("standings", prepareStandings());
            json.add("gameEnd", board.hasPlayerWon(playerName));
            gamedata.setJson(json.build());
            gd = gamedata;
            logger.info("game data " + gd.getJson().toString());
            broadCastMsg(gd);
        } catch (NumberFormatException | IOException | EncodeException ex) {
            ex.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void broadCastMsg(GameData gd) throws IOException, EncodeException {
        for (Session currPeer : peers) {
            currPeer.getBasicRemote().sendObject(gd);
        }
    }

    private JsonArray prepareStandings() {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Player player : cache.getBoard().getPlayerObsOnBoard()) {
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("name", player.getName());
            objectBuilder.add("position", player.getPosition());
            arrayBuilder.add(objectBuilder.build());
        }
        return arrayBuilder.build();
    }
}
