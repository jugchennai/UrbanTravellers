/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
          //  sendSignalChange();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendSignalChange() throws DeploymentException, IOException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://localhost:8080/SignalChange";
        container.connectToServer(SignalChangeEndpointClient.class, URI.create(uri));
    }
}
