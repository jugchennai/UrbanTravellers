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

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author prasannakumar
 */
public class GameCacheTest {

    private GameCache gameCache = GameCache.getInstance();

    @Test
    public void noGameBoardShouldExistOnStart() {
        assertEquals(gameCache.getBoards().size(), 0);
    }

    @Test
    public void gameShouldContainAtmostOnlyOneGame() {
        gameCache.getBoard();
        assertEquals(gameCache.getBoards().size(), 1);
        gameCache.getBoard();
        assertEquals(gameCache.getBoards().size(), 1);
    }

    @Test
    public void gameShouldBeZeroAfterReset() {
        gameCache.resetBoard();
        assertEquals(gameCache.getBoards().size(), 0);
    }
}
