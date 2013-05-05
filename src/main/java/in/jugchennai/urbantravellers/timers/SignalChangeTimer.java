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
package in.jugchennai.urbantravellers.timers;

import in.jugchennai.urbantravellers.game.GameBoard;
import in.jugchennai.urbantravellers.game.GameBoardConfig;
import in.jugchennai.urbantravellers.game.GameCache;
import in.jugchennai.urbantravellers.websocket.SignalChangeEndpointClient;
import java.io.IOException;
import java.net.URI;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author prasannakumar
 */
@Stateless
public class SignalChangeTimer {

    private static final GameCache cache = GameCache.getInstance();

    /**
     *
     */
    @Schedule(minute = "*/1", hour = "*", persistent = false)
    public void toggleSignal() {
        try {
            GameBoard gameBoard = cache.getBoard();
            GameBoardConfig boardConfig = gameBoard.getBoardConfig();
            for (int i = 0; i < boardConfig.getNoOfSignalPoints(); i++) {
                boardConfig.toggleSignal(
                        boardConfig.getSigPos()[i].getSignalPos());
            }
            gameBoard.setBoardConfig(boardConfig);
            sendSignalChange();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * 
     * @throws DeploymentException
     * @throws IOException 
     */
    public void sendSignalChange() throws DeploymentException, IOException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://localhost:8080/urbantravellers/SignalChange";
        container.connectToServer(SignalChangeEndpointClient.class, URI.create(uri));
    }
}
