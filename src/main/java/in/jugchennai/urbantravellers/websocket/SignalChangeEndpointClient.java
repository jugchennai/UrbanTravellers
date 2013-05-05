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
            builder.add("point", String.valueOf(signalPoint.getSignalPos()));
            builder.add("color", signalPoint.getSignalColor().name());
            session.getBasicRemote().sendObject(builder.build());
        }
    }
}
