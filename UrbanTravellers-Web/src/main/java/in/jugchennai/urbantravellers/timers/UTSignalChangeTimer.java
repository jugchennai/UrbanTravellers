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
 * limitations under the License
 */
package in.jugchennai.urbantravellers.timers;

import in.jugchennai.urbantravellers.game.GameBoard;
import in.jugchennai.urbantravellers.game.GameBoardConfig;
import in.jugchennai.urbantravellers.game.GameCache;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;

/**
 *
 * @author prasannakumar
 */
@Stateless
public class UTSignalChangeTimer {

    private Logger logger = Logger.getLogger(UTSignalChangeTimer.class);
    private static final GameCache cache = GameCache.getInstance();

    /**
     *
     */
    @Schedule(minute = "*/3", hour = "*", persistent = false)
    public void toggleSignal() {
        try {
            GameBoard gameBoard = cache.getBoard();
            GameBoardConfig boardConfig = gameBoard.getBoardConfig();
            for (int i = 0; i < boardConfig.getNoOfSignalPoints(); i++) {
                boardConfig.toggleSignal(
                        boardConfig.getSigPos()[i].getSignalPos());
                // code to call websocket client 
            }
            gameBoard.setBoardConfig(boardConfig);
        } catch (Exception ex) {
            logger.error("exception occured " + ex);
        }
    }
}