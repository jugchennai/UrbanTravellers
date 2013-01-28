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

/**
 *
 *  @author Prasanna Kumar <prassee.sathian@gmail.com>
 */
public class GameBoardFactory {

    public static GameBoard createGameBoard(
            int maxPoints, int noOfSigPoints, int maxPlayers) {
        return new GameBoard(
                new GameBoardConfig(maxPoints, noOfSigPoints,
                maxPlayers, createPoints()));
    }

    private static int[] createPoints() {
        int a[] = new int[2];
        a[0] = 24;
        a[1] = 44;
        return a;
    }   
}
