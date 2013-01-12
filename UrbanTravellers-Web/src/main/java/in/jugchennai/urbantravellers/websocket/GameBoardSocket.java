/*
 * Copyright 2012 JUGChennai.
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
import in.jugchennai.urbantravellers.game.GameCache;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.WebSocketEndpoint;
import javax.websocket.WebSocketMessage;
import org.codehaus.jettison.json.JSONException;

/**
 * GameBoard endpoint
 *
 * @author prasannakumar
 */
@WebSocketEndpoint(value = "gameBoard",
encoders = {UTGameDataEncoder.class},
decoders = {UTGameDataDecoder.class},
factory = UTWebSocketEndPointFactory.class)
public class GameBoardSocket {

    private GameCache cache = GameCache.getInstance();
    private String gameId = "";

    /**
     * move player and check if the player won the race
     *
     * @param playerId
     * @param diceValue
     */
    @WebSocketMessage
    public synchronized void movePlayer(UTGamedata gamedata) {
        try {
            gamedata.getJson().getString("gameId");
            String playerId = gamedata.getJson().getString("playerId");
            int diceValue = gamedata.getJson().getInt("diceValue");
            GameBoard board = cache.getBoard(getGameId());
            board.movePlayerPosition(playerId, diceValue);
            board.hasPlayerWon(playerId);
        } catch (JSONException ex) {
            Logger.getLogger(GameBoardSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getGameId() {
        return gameId;
    }
}