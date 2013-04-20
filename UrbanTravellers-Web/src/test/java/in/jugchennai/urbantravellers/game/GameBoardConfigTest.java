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

import static in.jugchennai.urbantravellers.game.fixture.GameTestFixture.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * test class for GameBoardConfig
 *
 *  @author Prasanna Kumar <prassee.sathian@gmail.com>
 */
public class GameBoardConfigTest {

    private GameBoardConfig boardConfig;

    /**
     * initializes the test class
     */
    @Before
    public void initTest() {
        boardConfig = new GameBoardConfig(lasPos, players, maxPlayers, 
                sp1, sp2);
    }

    /**
     * verify the game board configuration
     */
    @Test
    public void testConfigPostCreate() {
        assertEquals(lasPos, boardConfig.getLastPosOnBoard());
        assertEquals(players, boardConfig.getNoOfSignalPoints());
        assertTrue(boardConfig.getSigPos().length
                == boardConfig.getNoOfSignalPoints());
        assertTrue("fails for sp1", 
                boardConfig.getSigPos()[0].getSignalPos() == sp1);
        assertTrue("fails for sp2", 
                boardConfig.getSigPos()[1].getSignalPos() == sp2);
    }

    /**
     * the game board should change when signal toggled
     */
    @Test
    public void signalShouldChangeWhenToggled() {
        SignalColor color = boardConfig.getSigPos()[0].getSignalColor();
        boardConfig.toggleSignal(sp1);
        assertFalse("assert failed",
                color == boardConfig.getSigPos()[0].getSignalColor());
    }
}
