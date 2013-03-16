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
package in.jugchennai.urbantravellers.game;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * This is a application wide scheduler to toggle signal point across multiple
 * game instances.
 *
 * @author Prasanna Kumar <prassee.sathian@gmail.com>
 */
public final class GameCache {

    private static GameCache INSTANCE = new GameCache();
    private static Map<String, GameBoard> map = new HashMap();
    public static String GAME_ID = "game1";
    private Logger logger = Logger.getLogger(GameCache.class);
    public static String STD_BOARD_NAME = "UrbanTravellers";
    
    private GameCache() {
    }

    /**
     * get the singleton instance
     *
     * @return
     */
    public static GameCache getInstance() {
        return INSTANCE;
    }

    public Map<String, GameBoard> getBoards() {
        return this.map;
    }

    /**
     * add board to the cache for holding multiple game instances
     *
     * @param gameId - the value of the game created by the database
     * @param gameBoard
     */
//    public void addBoard(String gameId, GameBoard gameBoard) {
//        if (!map.containsKey(gameId)) {
//            map.put(gameId, gameBoard);
//            logger.info("added game to cache " + gameId);
//        }
//    }

    /**
     * obtains the board instance for the given game id
     *
     * @param gameId
     * @return
     * @throws Exception
     */
    public GameBoard getBoard() {
        if (map.isEmpty()) {
            map.put(GAME_ID,
                    GameBoardFactory.createGameBoard(STD_BOARD_NAME,
                    50, 2, 3));
        }
        return map.get(GAME_ID);
    }

    public void resetBoard() {
        map.remove(GAME_ID);
    }
}
