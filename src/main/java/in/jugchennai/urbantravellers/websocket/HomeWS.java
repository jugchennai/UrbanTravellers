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

import in.jugchennai.urbantravellers.game.GameCache;
import in.jugchennai.urbantravellers.game.GameStatus;
import in.jugchennai.urbantravellers.game.Player;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/HomeWS",
        encoders = {DataEncoder.class},
        decoders = {DataDecoder.class})
public class HomeWS {

    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    GameCache gameCache = GameCache.getInstance();

    @OnOpen
    public void onOpen(Session peer) {
        peers.add(peer);
    }

    @OnClose
    public void onClose(Session peer) {
        peers.remove(peer);
    }

    @OnMessage
    public void boradcastFigure(GameData figure, Session session) throws IOException, EncodeException {
        try {
            gameCache.getBoard().addPlayerToBoard(new Player(figure.getJson().getString("playerName")));
            GameData f = new GameData();
            JsonObjectBuilder builder = Json.createObjectBuilder();
            if (gameCache.getBoard().getGameStatus() == GameStatus.BOARD_FULL) {
                builder.add("startGame", "true");
            } else {
                StringBuffer buffer = new StringBuffer();
                for (String string : gameCache.getBoard().getPlayersOnBoard()) {
                    buffer.append(string + " , ");
                }
                builder.add("player", buffer.toString());
            }
            f.setJson(builder.build());
            figure = f;
            for (Session peer : peers) {
                peer.getBasicRemote().sendObject(figure);
            }
        } catch (Exception ex) {
            Logger.getLogger(HomeWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
