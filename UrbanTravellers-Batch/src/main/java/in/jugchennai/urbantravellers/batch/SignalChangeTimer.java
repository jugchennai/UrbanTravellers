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
package in.jugchennai.urbantravellers.batch;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import org.apache.log4j.Logger;

/**
 *
 * @author prasannakumar
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class SignalChangeTimer {

    Logger logger = Logger.getLogger(SignalChangeTimer.class);

    /**
     * this method changes the signal at certain interval of time so that
     */
    @Lock(LockType.WRITE)
    // @Schedule(minute="3")
    public void toggleSignal() {
        try {
//            GameBoard board = GameCache.getInstance().getBoard(GameCache.GAME_ID);
//            GameBoardConfig boardConfig = board.getBoardConfig();
//            for (SignalPoint point : board.getBoardConfig().getSigPos()) {
//                boardConfig.toggleSignal(point.getSignalPos());
//            }
//            board.setBoardConfig(boardConfig);
        } catch (Exception ex) {
            logger.error("failed to toggle the signal " + ex.getMessage());
        }
    }
}