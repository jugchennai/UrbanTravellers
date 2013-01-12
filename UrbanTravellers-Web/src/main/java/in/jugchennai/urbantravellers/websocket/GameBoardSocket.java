/*
 * Copyright 2012 JUGChennai.
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

/**
 * GameBoard endpoint
 *
 * @author prasannakumar
 */
public class GameBoardSocket {

    private GameCache cache = GameCache.getInstance();
    private String gameId = "";

    /**
     * move player and check if the player won the race
     *
     * @param playerId
     * @param diceValue
     */
    public void movePlayer(String playerId, int diceValue) {
        cache.getBoard(gameId).movePlayerPositionOnBoard(playerId, diceValue);
        cache.getBoard(gameId).hasPlayerWon(playerId);
    }
}