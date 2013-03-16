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
package in.jugchennai.urbantravellers.formbean;

import in.jugchennai.urbantravellers.game.GameBoard;
import in.jugchennai.urbantravellers.game.GameCache;
import in.jugchennai.urbantravellers.game.Player;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author MahiRaj Gosemath
 */
@ManagedBean
@RequestScoped
public class CreateGame {

    private String gameId;
    private GameBoard board;
    private Player player;
    private GameCache cache;
    @ManagedProperty(value = "#{loginBean.userName}")
    private String userName;

    /**
     * Creates a new instance of CreateGame
     */
    public CreateGame() {
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void createGame() {
        try {
            cache = GameCache.getInstance();
            /*hard coded GAME_ID to ensure only one game across app
             */
            player = new Player(userName);
            board = cache.getBoard();
            board.addPlayerToBoard(player);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
