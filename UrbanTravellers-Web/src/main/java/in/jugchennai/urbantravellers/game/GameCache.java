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
 *
 * @author sysadmin
 */
public final class GameCache {

    private static GameCache INSTANCE = new GameCache();
    private static Map<String, GameBoard> map = new HashMap();
    /**
     *
     */
    public static String GAME_ID = "game1";
    private Logger logger = Logger.getLogger(this.getClass());

    private GameCache() {
    }

    /**
     *
     * @return
     */
    public static GameCache getInstance() {
        return INSTANCE;
    }

    /**
     * add board to the cache
     *
     * @param gameId
     * @param gameBoard
     */
    public void addBoard(String gameId, GameBoard gameBoard) {
        if (!map.containsKey(gameId)) {
            map.put(gameId, gameBoard);
        }
    }

    /**
     *
     * @param gameId
     * @return
     * @throws Exception
     */
    public GameBoard getBoard(String gameId) throws Exception {
        if (map.containsKey(gameId)) {
            return map.get(gameId);
        } else {
            throw new Exception("gameId not found");
        }
    }
}
