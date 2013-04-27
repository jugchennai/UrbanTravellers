/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.jugchennai.urbantravellers.timers;

import in.jugchennai.urbantravellers.game.GameBoard;
import in.jugchennai.urbantravellers.game.GameBoardConfig;
import in.jugchennai.urbantravellers.game.GameCache;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
