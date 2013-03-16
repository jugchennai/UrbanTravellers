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
import java.io.IOException;
import javax.websocket.EncodeException;
import javax.websocket.Session;
import javax.websocket.WebSocketEndpoint;
import javax.websocket.WebSocketMessage;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * @author prasannakumar
 */
@WebSocketEndpoint(value = "/UTGameBootSocket",
        encoders = {DataEncoder.class},
        decoders = {DataDecoder.class})
public class GameBootSocket extends UTSocket {

    /**
     *
     * @param gd
     * @param peer
     * @throws IOException
     * @throws EncodeException
     * @throws JSONException
     */
    @WebSocketMessage
    public void broadCastMessage(GameData gd, Session peer)
            throws IOException, EncodeException, JSONException, Exception {
        String gameID = gd.getJson().get("gameId").toString();
        
        // we may not need these lines 
        GameBoard board = cache.getBoard();
        
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("players", board.getPlayersOnBoard());
        jSONObject.put("gameId", gameID);
        if (board.getPlayersOnBoard().size() == 3) {
            jSONObject.put("startGame", true);
        }
        gd.setJson(jSONObject);
        for (Session currPeer : peers) {
            currPeer.getRemote().sendObject(gd);
        }
    }

    @Override
    public void onOpen(Session peer) throws Exception {
        peers.add(peer);
    }

    @Override
    public void onClose(Session peer) {
        peers.remove(peer);
    }
}
