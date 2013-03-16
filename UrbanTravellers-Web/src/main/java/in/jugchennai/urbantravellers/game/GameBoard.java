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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;

/**
 * The class that models the game-board this is the underlying class which
 * reports about position of the players in the board and makes changes in their
 * position for the given dice value also helps to decide which player has won
 * the race.
 *
 * @author Prasanna Kumar <prassee.sathian@gmail.com>
 */
public class GameBoard {

    protected Map<String, Player> playerMap = new LinkedHashMap<>();
    private int lastPos;
    private int maxPlayers;
    private GameBoardConfig boardConfig;
    private Logger log = Logger.getLogger(GameBoard.class);
    private boolean hasPlayStarted = false;
    private GameStatus gameStatus = GameStatus.UNINITIALIZED;

    protected GameBoard() {
    }

    public GameBoard(GameBoardConfig boardConfig) {
        this.boardConfig = boardConfig;
        this.lastPos = boardConfig.getLastPosOnBoard();
        this.maxPlayers = boardConfig.getMaxNoOfPlayer();
    }

    /**
     * A player should be enrolled to the game until the max allowed players
     * reached
     *
     * @param player
     * @throws Exception
     */
    public void addPlayerToBoard(Player player) throws Exception {
        if (playerMap.size() <= boardConfig.getMaxNoOfPlayer()) {
            if (playerMap.isEmpty()) {
                this.gameStatus = GameStatus.INITIALIZED;
            }
            playerMap.put(player.getName(), player);
            log.info(" Player " + player.getName() + " has been added to the board");
        } else {
            throw new Exception("Max player reached");
        }
    }

    /**
     * player position on the board has to be updated each time dice is rolled
     *
     * @param name
     * @param diceValue
     * @return Player
     */
    public Player movePlayerPosition(String name, int diceValue) {
        Player player = playerMap.get(name);
        SignalPoint nearPoint = findNearestPoint(player.getPosition());
        log.info("\n " + name + " rolled > " + diceValue
                + "\n signal point > "
                + nearPoint.getSignalPos()
                + "\n signal color > " + nearPoint.getSignalColor());
        boolean move = false;
        if (nearPoint.isPositionInSignal(player.getPosition())) {
            if (nearPoint.allowedToGo(player.getPosition(), diceValue)) {
                move = true;
            }
        } else {
            move = true;
        }
        log.info("\n move > " + (move ? "allowed" : "not allowed"));
        if (move) {
            player.setDiceValue(diceValue);
            player.setPosition(player.getPosition() + diceValue);
        }
        return player;
    }

    public String getNextPlayer(String playerName) {
        int index = 0;
        String nextPlayer = null;
        String players[] = (String[]) playerMap.keySet().toArray();
        while (index < playerMap.keySet().toArray().length) {
            if (players[index].toString().equals(playerName)) {
                int val = index++;
                if (index++ == players.length) {
                    val = 0;
                }
                nextPlayer = players[val];
                break;
            }
            index++;
        }
        return nextPlayer;
    }

    /**
     * short circuit the game flow by finding if the given player has reach the
     * last position in the game board
     *
     * @param pos
     * @return boolean
     */
    public boolean hasPlayerWon(String pos) {
        return playerMap.get(pos).getPosition()
                == this.boardConfig.getLastPosOnBoard();
    }

    public void startPlay() {
        this.hasPlayStarted = true;
        this.gameStatus = GameStatus.HAPPENING;
    }

    public int getCurrentPlayersOnBoard() {
        return playerMap.size();
    }

    public Set<String> getPlayersOnBoard() {
        return playerMap.keySet();
    }

    public boolean hasGameStarted() {
        return hasPlayStarted;
    }

    /**
     * local helper method to find the nearest proximate signal point
     *
     * @param pos
     * @return SignalPoint
     */
    private SignalPoint findNearestPoint(int pos) {
        SignalPoint spoint = null;
        for (SignalPoint point : this.boardConfig.getSigPos()) {
            if (pos <= point.getSignalPos()) {
                System.out.println(" > " + point.getSignalColor());
                spoint = point;
                break;
            }
        }
        return spoint;
    }

    public GameBoardConfig getBoardConfig() {
        return boardConfig;
    }

    public void setBoardConfig(GameBoardConfig boardConfig1) {
        log.info(" board config changed ");
        log.info(" with signal points " + this.boardConfig.getSigPos());
        this.boardConfig = boardConfig1;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.lastPos;
        hash = 13 * hash + this.maxPlayers;

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GameBoard other = (GameBoard) obj;
        if (this.lastPos != other.lastPos) {
            return false;
        }
        if (this.maxPlayers != other.maxPlayers) {
            return false;
        }
        if (this.boardConfig != other.boardConfig) {
            return false;
        }
        return true;
    }
}
