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
package in.jugchennai.urbantravellers.game;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author prasannakumar
 */
public class GameBoardTest {

    private GameBoardConfig boardConfig = new GameBoardConfig(16, 2, 6);
    private GameBoard gameBoard = new GameBoard(boardConfig);
    private Player pras = new Player("pras");
    private Player raj = new Player("raj");

    @Before
    public void init() {
        try {
            gameBoard.addPlayerToBoard(pras);
            gameBoard.addPlayerToBoard(raj);
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void testToAddPlayerToBoard() {
        try {
            assertEquals(pras, gameBoard.playerMap.get(pras.getName()));
            assertEquals(raj, gameBoard.playerMap.get(raj.getName()));
        } catch (Exception ex) {
            fail("Max Player Reached");
        }
    }

    @Test
    public void gameBoardShouldNotAllowMoreThanMaxPlayers() {
        try {
            assertTrue(gameBoard.playerMap.size()
                    < gameBoard.getBoardConfig().getMaxNoOfPlayer());
            gameBoard.addPlayerToBoard(new Player("p3"));
            gameBoard.addPlayerToBoard(new Player("p4"));
            gameBoard.addPlayerToBoard(new Player("p5"));
            gameBoard.addPlayerToBoard(new Player("p6"));
            gameBoard.addPlayerToBoard(new Player("p7"));
            assertTrue(gameBoard.playerMap.size()
                    > gameBoard.getBoardConfig().getMaxNoOfPlayer());
        } catch (Exception ex) {
            assertEquals("Max player reached", ex.getMessage());
        }
    }

    @Test
    public void playerPositionShouldChangeAfterRollingDice() {
        pras = gameBoard.playerMap.get("pras");
        raj = gameBoard.playerMap.get("raj");
        assertEquals(gameBoard.movePlayerPosition("pras", 2),
                pras);
        assertEquals(gameBoard.movePlayerPosition("raj", 1),
                raj);
    }

    @Test
    public void playerShoulMoveOnlyForDiceValOneOnSignalRed() {
        pras = gameBoard.movePlayerPosition("pras", 2);
        assertEquals(2, pras.getPosition());

        pras = gameBoard.movePlayerPosition("pras", 2);
        assertFalse(1 == pras.getPosition());

        pras = gameBoard.movePlayerPosition("pras", 1);
        assertTrue(3 == pras.getPosition());

        pras = gameBoard.movePlayerPosition("pras", 1);
        assertTrue(4 == pras.getPosition());

        pras = gameBoard.movePlayerPosition("pras", 5);
        assertFalse(9 == pras.getPosition());

        pras = gameBoard.movePlayerPosition("pras", 1);
        assertTrue("failed at 5", 5 == pras.getPosition());
    }

    @Test
    public void playerShouldMoveAheadWhenSignalTurnsGreen() {
        pras = gameBoard.movePlayerPosition("pras", 2);
        assertEquals(2, pras.getPosition());

        pras = gameBoard.movePlayerPosition("pras", 2);
        assertFalse(1 == pras.getPosition());

        pras = gameBoard.movePlayerPosition("pras", 1);
        assertTrue(3 == pras.getPosition());

        pras = gameBoard.movePlayerPosition("pras", 1);
        assertTrue(4 == pras.getPosition());

        gameBoard.getBoardConfig().toggleSignal(
                gameBoard.getBoardConfig().getSigPos()[0].getSignalPos());

        pras = gameBoard.movePlayerPosition("pras", 5);
        assertTrue(9 == pras.getPosition());
    }
}
