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
import javax.websocket.WebSocketEndpoint;

/**
 *
 * @author prasannakumar
 */
@WebSocketEndpoint(value = "/UTGameSocket",
encoders = {DataEncoder.class},
decoders = {DataDecoder.class})
public class GameBootSocket {
    private static final GameCache cache = GameCache.getInstance();
    // todo new methods to add players to the game board 
    // create game board and put game id in cache 
}
