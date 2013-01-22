/*
 * Copyright 2013 JUGChennai.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package in.jugchennai.urbantravellers.websocket;

import in.jugchennai.urbantravellers.game.GameBoard;
import in.jugchennai.urbantravellers.game.GameBoardConfig;
import in.jugchennai.urbantravellers.game.GameCache;
import in.jugchennai.urbantravellers.game.Player;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.EndpointFactory;
import javax.websocket.Session;
import javax.websocket.WebSocketClose;
import javax.websocket.WebSocketEndpoint;
import javax.websocket.WebSocketMessage;
import javax.websocket.WebSocketOpen;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


/**
 *
 * @author Prasanna Kumar <prassee.sathian@gmail.com>
 * @author Rajmahendra Hegde <rajmahendra@gmail.com>
 */
@WebSocketEndpoint(value = "/UTGameSocket",
encoders = {DataEncoder.class},
decoders = {DataDecoder.class},
factory = GameBoardEndpointFactory.class)
public class GameBoardSocket {
    
    private Logger logger = Logger.getLogger(this.getClass());
    // the getInstance method does some bootstrap activities
    private static GameCache cache = GameCache.getInstance();
    private Set<Session> peers = Collections.synchronizedSet(new HashSet());
    
    static {
        GameBoardConfig boardConfig = new GameBoardConfig(25, 2, 6);
        try {
            cache.addBoard(GameCache.GAME_ID, new GameBoard(boardConfig));
            GameBoard board = cache.getBoard(GameCache.GAME_ID);
            board.addPlayerToBoard(new Player("Pras"));
            board.addPlayerToBoard(new Player("Raj"));
            board.addPlayerToBoard(new Player("Shiv"));
        } catch (Exception ex) {
            System.out.println("ex while socket boot " + ex);
        }
    }
    
    @WebSocketOpen
    public void onOpen(Session peer) throws Exception {
        logger.info("added player to session ");
        peers.add(peer);
    }
    
    @WebSocketClose
    public void onClose(Session peer) {
        logger.info("removing player from session");
        peers.remove(peer);
    }
    
    /**
     * 
     * @param gd
     * @param peer
     * @throws IOException
     * @throws EncodeException 
     */
    @WebSocketMessage
    public void broadCastMessage(Gamedata gd, Session peer)
            throws IOException, EncodeException {
        try {
            logger.info("Boradcast Game Data:" + gd);
            String playerName = gd.getJson().getString("playerName");
            String diceValue = gd.getJson().getString("diceValue");
            
            GameBoard board = cache.getBoard(GameCache.GAME_ID);
            Player player = board.movePlayerPosition(playerName,
                    Integer.parseInt(diceValue));
            Gamedata gamedata = new Gamedata();
            JSONObject json = new JSONObject();
            json.put("outcome", "Player " + player.getName() + " has moved to "
                    + player.getPosition() + " by throwing " + diceValue);
            gamedata.setJson(json);
            for (Session currPeer : peers) {
                logger.info("send info to peers");
                currPeer.getRemote().sendObject(gamedata);
            }
        } catch (JSONException ex) {
            logger.info("json exception has occured");
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        } 
    }
}
class GameBoardEndpointFactory implements EndpointFactory {
    
    private Logger logger = Logger.getLogger(this.getClass());
    
    @Override
    public Object createEndpoint() {
        logger.info("creating new end point");
        return null;
    }
}
