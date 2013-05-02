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
 * POJO to hold constants expected by GameBoard
 *
 * @author Prasanna Kumar <prassee.sathian@gmail.com>
 */
public class GameBoardConfig {

    private int lastPosOnBoard;
    private int noOfSignalPoints;
    private int maxNoOfPlayer;
    private SignalPoint[] sigPos;
    private int[] bs;

    /**
     * the constructor
     *
     * @param lastPosOnBoard
     * @param noOfSignalPoints
     * @param maxNoOfPlayer
     * @param points
     */
    public GameBoardConfig(int lastPosOnBoard,
            int noOfSignalPoints, int maxNoOfPlayer, int... points) {
        this.lastPosOnBoard = lastPosOnBoard-1;
        this.noOfSignalPoints = noOfSignalPoints;
        this.maxNoOfPlayer = maxNoOfPlayer;
        this.sigPos = new SignalPoint[noOfSignalPoints];
        this.bs = new int[noOfSignalPoints];

        int index = 0;
        int bsindex = 0;
        for (int point : points) {
            if (index < 2) {
                this.sigPos[index] = new SignalPoint(point);
            } else {
                this.bs[bsindex] = point;
                bsindex++;
            }
            index++;
        }
    }

    /**
     * toggle the signal color, clients of this class can make use of this to change he signal color at any
     * point of time in the game board
     *
     * @param pos
     */
    public void toggleSignal(int pos) {
        for (SignalPoint point : sigPos) {
            if (point.getSignalPos() == pos) {
                System.out.println("changing signal " + point.getSignalPos());
                point.setSignalColor(
                        point.getSignalColor() == SignalColor.RED
                        ? SignalColor.GREEN : SignalColor.RED);
                break;
            }
        }
    }

    public int getLastPosOnBoard() {
        return lastPosOnBoard;
    }

    public int getNoOfSignalPoints() {
        return noOfSignalPoints;
    }

    public int getMaxNoOfPlayer() {
        return maxNoOfPlayer;
    }

    public SignalPoint[] getSigPos() {
        return sigPos;
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
