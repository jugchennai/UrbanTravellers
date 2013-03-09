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
package in.jugchennai.urbantravellers.game.fixture;

import in.jugchennai.urbantravellers.game.GameBoardConfig;
import in.jugchennai.urbantravellers.game.Player;
import java.util.Random;

/**
 * the class which holds the data required for testing
 *
 * @author Prasanna Kumar <prassee.sathian@gmail.com>
 */
public class GameTestFixture {

    public static final int lasPos = 50;
    public static final int players = 2;
    public static final int maxPlayers = 6;
    public static final int sp1 = 24;
    public static final int sp2 = 44;
    public static GameBoardConfig boardConfig =
            new GameBoardConfig(lasPos, players, maxPlayers, sp1, sp2);
    public static Player p3 = new Player("p3");
    public static Player p4 = new Player("p4");
    public static Player p5 = new Player("p5");
    public static Player p6 = new Player("p6");
    public static Player p7 = new Player("p7");
    private static Random r = new Random(6);

    /**
     * @return random dice value
     */
    public static int emulateDice() {
        int dv = r.nextInt(6);
        if (dv == 0) {
            return emulateDice();
        }
        return dv;
    }
}
