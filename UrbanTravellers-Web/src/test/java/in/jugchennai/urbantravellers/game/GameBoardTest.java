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

import in.jugchennai.urbantravellers.game.fixture.GameTestFixture;
import static in.jugchennai.urbantravellers.game.fixture.GameTestFixture.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * the test class for GameBoard
 *
 * @author Prasanna Kumar <prassee.sathian@gmail.com>
 */
public class GameBoardTest {

    private GameBoard gameBoard;
    private Player pras = new Player("pras");
    private Player raj = new Player("raj");
    private int initpos = 0;

    /**
     * created two players and add them in the board assign each player a
     * initial position init the test case
     */
    @Before
    public void init() {
        try {
            gameBoard = new GameBoard(boardConfig);
            gameBoard.addPlayerToBoard(pras);
            gameBoard.addPlayerToBoard(raj);
        } catch (Exception ex) {
            fail();
        }
    }

    /**
     * test to check for acceptance of adding player to board
     */
    @Test
    public void testToAddPlayerToBoard() {
        try {
            assertEquals(pras, gameBoard.playerMap.get(pras.getName()));
            assertEquals(raj, gameBoard.playerMap.get(raj.getName()));
            assertTrue(2 == gameBoard.playerMap.size());
        } catch (Exception ex) {
            fail("Max Player Reached " + ex);
        }
    }

    /**
     * game board should not allow more than max allowed players
     */
    @Test
    public void gameBoardShouldNotAllowMoreThanMaxPlayers() {
        try {
            assertTrue(gameBoard.playerMap.size()
                    < gameBoard.getBoardConfig().getMaxNoOfPlayer());
            gameBoard.addPlayerToBoard(GameTestFixture.p3);
            gameBoard.addPlayerToBoard(GameTestFixture.p4);
            gameBoard.addPlayerToBoard(GameTestFixture.p5);
            gameBoard.addPlayerToBoard(GameTestFixture.p6);
            gameBoard.addPlayerToBoard(GameTestFixture.p7);
            assertTrue(gameBoard.playerMap.size()
                    > gameBoard.getBoardConfig().getMaxNoOfPlayer());
        } catch (Exception ex) {
            assertEquals("Max player reached", ex.getMessage());
        }
    }

    /**
     * player should be move to new position after rolling dice this test
     * assumes that player is not anywhere in signal range
     */
    @Test
    public void playerPositionShouldChangeAfterRollingDice() {
        pras = gameBoard.playerMap.get("pras");
        raj = gameBoard.playerMap.get("raj");
        pras.setPosition(initpos);
        raj.setPosition(initpos);
        int prasPos = GameTestFixture.emulateDice();
        int rajPos = GameTestFixture.emulateDice();
        gameBoard.movePlayerPosition("pras", prasPos);
        gameBoard.movePlayerPosition("raj", rajPos);
        assertTrue("failed for pras turn ", initpos + prasPos == pras.getPosition());
        assertTrue("failed for raj turn ", initpos + rajPos == raj.getPosition());
    }

    /**
     * test to hold the vehicle at signal position until signal is red
     */
    @Test
    public void playerShoulMoveOnlyForDiceValOneOnSignalRed() {
        initpos = 20;
        int diceValue = 2;
        pras.setPosition(initpos); // 20

        // 20 + 2 = 22 allowed
        automatePlayerMove(diceValue);

        // 22 + 1 = 23 allowed 
        diceValue = 1;
        automatePlayerMove(diceValue);

        // 23+1 = 24 allowed 
        diceValue = 1;
        automatePlayerMove(diceValue);

        // 24 + 1 = 25 not allowed (signal still in red)
        diceValue = 1;
        initpos = initpos + diceValue;
        pras = gameBoard.movePlayerPosition("pras", diceValue);
        assertFalse("assert failed expt => " + (initpos) + " obt=> " + pras.getPosition(),
                initpos == pras.getPosition());

        // assert failed so reverting back to prev position
        initpos = initpos - diceValue;

        // change signal to green - this will be done by batch
        GameBoardConfig boardConfig = gameBoard.getBoardConfig();
        boardConfig.toggleSignal(
                gameBoard.getBoardConfig().getSigPos()[0].getSignalPos());
        gameBoard.setBoardConfig(boardConfig);

        // 24 + 1 = 25 allowed (signal changed to green)
        diceValue = 1;
        automatePlayerMove(diceValue);
    }

    /**
     * a helper method to automate and assert player position b4 and after dice
     * roll
     *
     * @param diceValue
     */
    private void automatePlayerMove(int diceValue) {
        initpos = initpos + diceValue;
        pras = gameBoard.movePlayerPosition("pras", diceValue);
        assertTrue("assert failed expt => " + (initpos) + " obt=> " + pras.getPosition(),
                initpos == pras.getPosition());
    }
}
