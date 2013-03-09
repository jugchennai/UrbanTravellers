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

import javax.websocket.*;
import org.codehaus.jettison.json.JSONObject;

/**
 * this client would be used by the EJBTimer to send frequent updates about
 * players joined the board
 *
 * @author prasannakumar
 */
@WebSocketClient
public class GameBootSocketClient {

    private JSONObject jSONObject;

    public GameBootSocketClient(JSONObject message) {
        jSONObject = message;
    }

    /**
     *
     * @param peer
     * @throws Exception
     */
    @WebSocketOpen
    public void sendMessage(Session peer) throws Exception {
        peer.getRemote().sendObject(this.jSONObject);
    }
}