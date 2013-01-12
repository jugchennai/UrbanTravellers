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

/**
 *
 * @author sysadmin
 */
public class GameCache {

    private static GameCache INSTANCE = new GameCache();
    private Map<String, GameBoard> map = new HashMap();

    private GameCache() {
    }

    public static GameCache getInstance() {
        return INSTANCE;
    }

    /**
     * add board to the cache
     * @param gameId
     * @param gameBoard 
     */
    public void addBoard(String gameId, GameBoard gameBoard) {
        if (!map.containsKey(gameId)) {
            map.put(gameId, gameBoard);
        }
    }

    public GameBoard getBoard(String gameId) {
        return map.get(gameId);
    }
}
