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

/**
 * POJO to hold constants expected by GameBoard
 *
 * @author prasannakumar
 */
public class GameBoardConfig {

    private int lastPosOnBoard;
    private int noOfSignalPoints;
    private int maxNoOfPlayer;
    private SignalPoint[] sigPos;

    /**
     * @param lastPosOnBoard
     * @param noOfSignalPoints
     * @param maxNoOfPlayer
     */
    public GameBoardConfig(int lastPosOnBoard,
            int noOfSignalPoints, int maxNoOfPlayer, int... points) {
        this.lastPosOnBoard = lastPosOnBoard;
        this.noOfSignalPoints = noOfSignalPoints;
        this.maxNoOfPlayer = maxNoOfPlayer;
        this.sigPos = new SignalPoint[noOfSignalPoints];
        int index = 0;
        for (int point : points) {
            this.sigPos[index] = new SignalPoint(point);
            index++;
        }
    }

    /**
     *
     * @return
     */
    public int getLastPosOnBoard() {
        return lastPosOnBoard;
    }

    /**
     *
     * @return
     */
    public int getNoOfSignalPoints() {
        return noOfSignalPoints;
    }

    /**
     *
     * @return
     */
    public int getMaxNoOfPlayer() {
        return maxNoOfPlayer;
    }

    /**
     *
     * @return
     */
    public SignalPoint[] getSigPos() {
        return sigPos;
    }

    /**
     *
     * @param pos
     */
    public void toggleSignal(int pos) {
        for (SignalPoint point : sigPos) {
            if (point.getSignalPos() == pos) {
                point.setSignalColor(
                        point.getSignalColor() == SignalColor.RED
                        ? SignalColor.GREEN : SignalColor.RED);
                break;
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.lastPosOnBoard;
        hash = 53 * hash + this.noOfSignalPoints;
        hash = 53 * hash + this.maxNoOfPlayer;
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
        final GameBoardConfig other = (GameBoardConfig) obj;
        if (this.lastPosOnBoard != other.lastPosOnBoard) {
            return false;
        }
        if (this.noOfSignalPoints != other.noOfSignalPoints) {
            return false;
        }
        if (this.maxNoOfPlayer != other.maxNoOfPlayer) {
            return false;
        }
        return true;
    }
}